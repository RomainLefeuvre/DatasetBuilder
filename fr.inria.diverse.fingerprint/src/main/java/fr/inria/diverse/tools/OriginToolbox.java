package fr.inria.diverse.tools;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.maps.NodeIdMap;

import fr.inria.diverse.Graph;
import fr.inria.diverse.LambdaExplorer;
import fr.inria.diverse.query.GraphQueryRunner;
import scala.Tuple2;

/*Class that contains all the different treatments, functions needed to integrate
the visit of each origin. Here we will not integrate it in the most efficient manner, as it is preferable
to do it directly in the generation of the compressed version of the PropertyGraphDataset.
*/
public class OriginToolbox extends SwhGraphProperties {
	static Logger logger = LogManager.getLogger(OriginToolbox.class);
	// The path where the results attribute will be saved in the export folder
	static String resultFileName = "originsSnaps.bin";
	// The path where the list of origins will be saved in the export folder
	private String originPath = "origins/origins";
	// The result map containing the snapshots id and their timestamps for each
	// origins
	private OriginMap results = new OriginMap();
	// Spark attribute
	private SparkSession spark;
	// The originVisitStatus dataframe
	private Dataset<Row> originVisitStatus;
	// The origin List
	private List<Long> origins;
	// Bypass origin termination check to avoid graph loading
	private Boolean bypass = false;
	private Graph g;

	public OriginToolbox(Boolean bypass) throws IOException {
		super(Configuration.getInstance().getGraphPath().toString());
		this.bypass = bypass;
		this.init();
	}

	public OriginToolbox(Graph g) throws IOException {
		super(Configuration.getInstance().getGraphPath().toString());
		this.g = g;
		this.init();
	}

	/**
	 * Initialize the current SwhGraphProperties attribute, the spark session for
	 * relational query ToDo migrate the SwhGraphProperties to an association
	 * instead of inheritance in order to leverage on the existing
	 * SwhGraphProperties when a graph is pass;
	 * 
	 * @throws IOException
	 */
	public void init() throws IOException {
		int totalThread = Configuration.getInstance().getThreadNumber();
		SparkConf conf = new SparkConf().setMaster("local[" + (totalThread - 2) + "]").setAppName("dataSetBuilder")
				.set("spark.driver.memory", "" + Runtime.getRuntime().freeMemory()).set("spark.driver.cores", "" + 2)
				.set("spark.driver.maxResultSize", "" + 0);
		spark = SparkSession.builder().config(conf).getOrCreate();
		Dataset<String> logData = spark.read().textFile("./log").cache();
		logger.debug("Loading NodeIdMap");
		this.nodeIdMap = new NodeIdMap(Configuration.getInstance().getGraphPath().toString());
		logger.debug("Loading NodeIdMap - over");
		logger.debug("Loading messages");
		this.loadMessages();
		logger.debug("Loading messages - over");
		results = new OriginMap();
		this.loadOrComputeOrigins();
	}

	public OriginMap getResults() {
		return results;
	}

	public List<Long> getOrigins() {
		return this.origins;
	}

	public void run() {
		Path resultUri = Paths.get(Configuration.getInstance().getExportPath().toString(), resultFileName);
		if (ToolBox.checkIfExist(resultUri.toString())) {
			logger.info("Loading " + resultUri);
			results = ToolBox.deserialize(resultUri.toString());
			logger.info("Loading " + resultUri + "Over");

		} else {
			logger.info("Computing " + resultUri);
			logger.debug("Get Snapshots information from relational version");
			Dataset<Row> queryRes = getSnapshotsFromRelationalVersion();
			populateResultFromRelationalQueryResult(queryRes);
			logger.debug("Export Result");
			ToolBox.serialize(results, resultUri.toString());
			logger.info("Computing " + resultUri + " over");
			spark.close();
		}
	}

	/**
	 * Take as input a Dataset<Row> : <OriginId,List<snapshotId,timestamp>,row_id>
	 * and populate the OriginMap
	 * 
	 * @param queryRes Dataset<Row>
	 */
	public void populateResultFromRelationalQueryResult(Dataset<Row> queryRes) {
		// Collect the table in 5 batch
		long numRows = queryRes.count();
		int chunkSize = (int) (numRows / 5);
		for (int currentRow = 0; currentRow <= numRows; currentRow = currentRow + chunkSize) {
			long start = currentRow;
			long end = currentRow + 1000 < numRows ? currentRow + chunkSize : numRows + 1;
			Dataset<Row> batch = queryRes.where("row_id >=" + start + " AND row_id<" + end);
			batch.collectAsList().parallelStream().forEach(row -> {
				// The actual originId
				Long originId = row.getLong(0);
				// Create the corresponding SnapTimestampMap
				SnapTimestampMap snaps = new SnapTimestampMap();
				NodeIdMap nodeIdMapCopy = nodeIdMap.copy(); // Populate snaps
				row.getList(1).stream().forEach(snapRow -> {
					SWHID snapSWHID = new SWHID("swh:1:snp:" + ((Row) snapRow).getString(0));
					Long snapId = nodeIdMapCopy.getNodeId(snapSWHID, false);
					Long timestamp = ((Row) snapRow).getTimestamp(1).getTime();
					snaps.addSnap(snapId, timestamp);
				});
				// Add the current origin to the results attribute
				synchronized (results) {
					results.addSnaps(originId, snaps);
				}
			});

		}

	}

	/**
	 * Query the relational table origin_visit_status with spark and return a
	 * Dataset<Row> : <OriginId,List<snapshotId,timestamp>,row_id>
	 * 
	 * @return Dataset<Row>
	 */
	private Dataset<Row> getSnapshotsFromRelationalVersion() {
		Path tmpPath = Paths.get(Configuration.getInstance().getExportPath().toString(), "tmp");
		Path urlIdPath = Paths.get(Configuration.getInstance().getExportPath().toString(), "origin_url_id");

		if (!ToolBox.checkIfExist(tmpPath.toString())) {
			/**** First we construct the Dataframe<OriginUrl,OriginId> ***/
			logger.debug("Retrieving Origin URL");
			List<Tuple2<String, Long>> originIdUrlTuple = origins.parallelStream().map(originId -> {
				String url = this.copy().getUrl(originId);
				return new Tuple2<String, Long>(url, originId);
			}).collect(Collectors.toList());

			logger.debug("Convert  List<Tuple2<OriginUrl, originId>> to a list of Row");
			List<Row> originIdUrl = originIdUrlTuple.parallelStream()
					.map(tuple -> RowFactory.create(tuple._1, tuple._2)).collect(Collectors.toList());

			logger.debug("Spark processes");
			// The Schema of the new DF that will be created
			StructType schema = DataTypes.createStructType(new StructField[] {
					DataTypes.createStructField("originUrl", DataTypes.StringType, true, Metadata.empty()),
					DataTypes.createStructField("originId", DataTypes.LongType, true, Metadata.empty()) });
			// Create the dataframe
			Dataset<Row> originIdUrlDf = spark.createDataFrame(originIdUrl, schema).na().drop().cache();
			originIdUrlDf.write().mode("overwrite").format("parquet").save(urlIdPath.toString());

			/****
			 * Then we load the origin_visit_status orc file an do computations on it
			 ****/
			originVisitStatus = spark.read().format("orc")
					.load(Paths.get(Configuration.getInstance().getRelationalPath().toString(), "origin_visit_status/")
							.toString());
			originVisitStatus.createOrReplaceTempView("originVisitStatus");
			// Filter non full snapshots
			Dataset<Row> fullSnap = originVisitStatus.na().drop().where("status='full'").select("snapshot", "date",
					"origin");
			// Perform Join and add row_id column for batch processing
			WindowSpec window = Window.orderBy(functions.col("originId"));
			Dataset<Row> queryRes = fullSnap
					.join(originIdUrlDf, originIdUrlDf.col("originUrl").equalTo(fullSnap.col("origin")))
					.select("snapshot", "date", "originId").groupBy("originId")
					.agg(functions.collect_list(functions.struct("snapshot", "date")).as("snapshot")).na().drop()
					.withColumn("row_id", functions.row_number().over(window)).cache();
			queryRes.write().mode("overwrite").format("parquet").save(tmpPath.toString());
			return queryRes;
		} else {
			logger.debug("Loading temp result");
			return spark.read().format("parquet").load(tmpPath.toString()).cache();
		}
	}

	/**
	 * Compute the list of origins id in the graph, load it from checkpoint if it
	 * exist.
	 * 
	 * A bypass mechanism has been implemented in order to avoid to load the entire
	 * graph in standalone mode (cf main of this class) when the file already exist.
	 */
	private void loadOrComputeOrigins() {
		Path originPathString = Paths.get(Configuration.getInstance().getExportPath().toString(), originPath);
		if (ToolBox.checkIfExist(originPathString.toString()) && this.bypass) {
			logger.debug("Loading Origins");
			this.origins = ToolBox.deserialize(originPathString.toString());
			logger.debug("Origins Loaded-");

		} else {
			logger.debug("Computing Origins");

			try {
				if (g == null) {
					g = new Graph();
					g.loadGraph();
				}
				this.origins = new LambdaExplorer<Long, Long>(g) {
					@Override
					public Long exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
						return graphCopy.getNodeType(currentElement) == SwhType.ORI ? currentElement : null;
					}

					@Override
					protected Path getExportPath() {
						String uuid = UUID.randomUUID().toString();
						return originPathString;
					}
				}.explore(true, 10000000L);
				logger.debug("Computing Origins - over");

			} catch (Exception e) {
				throw new RuntimeException("Error while retrieving origin");
			}
		}
	}

// **********************Inner class**********************
	public static class OriginMap implements Serializable {
		private static final long serialVersionUID = -1339172231823890829L;

		private Map<Long, SnapTimestampMap> originSnaps;

		public OriginMap(Map<Long, SnapTimestampMap> originSnaps) {
			super();
			this.originSnaps = originSnaps;
		}

		public OriginMap() {
			originSnaps = new HashMap<>();
		}

		public SnapTimestampMap getSnaps(Long originId) {
			return originSnaps.getOrDefault(originId, null);
		}

		public void addSnap(Long originId, Tuple2<Long, Long> snap) {
			if (!this.originSnaps.containsKey(originId))
				this.originSnaps.put(originId, new SnapTimestampMap());

			this.originSnaps.get(originId).addSnap(snap._1, snap._2);
		}

		public void addSnaps(Long originId, SnapTimestampMap snaps) {
			originSnaps.put(originId, snaps);
		}

		public Map<Long, SnapTimestampMap> getOriginSnaps() {
			return originSnaps;
		}

		public void setOriginSnaps(Map<Long, SnapTimestampMap> originSnaps) {
			this.originSnaps = originSnaps;
		}

	}

	public static class SnapTimestampMap implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -628036622945116642L;
		private Map<Long, Long> snapTimestamp;

		public SnapTimestampMap() {
			this.snapTimestamp = new HashMap<>();
		}

		public SnapTimestampMap(Map<Long, Long> snapTimestamp) {
			super();
			this.snapTimestamp = snapTimestamp;
		}

		public void addSnap(Long snapId, Long snapTimestamp) {
			this.snapTimestamp.put(snapId, snapTimestamp);
		}

		public Long getTimestamp(Long snapId) {
			return this.snapTimestamp.getOrDefault(snapId, null);
		}

		public Map<Long, Long> getSnapTimestamp() {
			return snapTimestamp;
		}

		public void setSnapTimestamp(Map<Long, Long> snapTimestamp) {
			this.snapTimestamp = snapTimestamp;
		}

	}

// **********************CLI For Standalone Usage **********************
	public static class Runner extends GraphQueryRunner {
		@Override
		public void run() {
			logger.info("Origin Toolbox");
			try {
				// Bypass integrity check if origins result already exist
				(new OriginToolbox(true)).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) throws IOException {
		Runner runner = new Runner();
		runner.init();
		runner.execute(new String[0]);

	}

}
