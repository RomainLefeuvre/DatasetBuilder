package fr.inria.diverse.tools;

import java.io.IOException;
import java.lang.reflect.Type;
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
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.maps.NodeIdMap;

import com.google.gson.reflect.TypeToken;

import fr.inria.diverse.Graph;
import fr.inria.diverse.LambdaExplorer;
import fr.inria.diverse.query.GraphQueryRunner;
import scala.Tuple2;

/*Class that contains all the different treatments, function needed to integrate
visit of each origin. Here we will not integrate it in the most efficient manner, as it is preferable
to do it directly in the generation of the compressed version of the PropertyGraphDataset.
*/
public class OriginToolbox extends SwhGraphProperties {
	static Logger logger = LogManager.getLogger(OriginToolbox.class);
	// The path where the results attribute will be saved in the export folder
	static String resultFileName = "originsSnaps.json";
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
		super(Configuration.getInstance().getGraphPath());
		this.bypass = bypass;
		this.init();
	}

	public OriginToolbox(Graph g) throws IOException {
		super(Configuration.getInstance().getGraphPath());
		this.init();
	}

	public void init() throws IOException {
		int totalThread = Configuration.getInstance().getThreadNumber();

		SparkConf conf = new SparkConf().setMaster("local[" + (totalThread - 2) + "]").setAppName("dataSetBuilder")
				.set("spark.driver.memory", "" + Runtime.getRuntime().freeMemory()).set("spark.driver.cores", "" + 2);
		spark = SparkSession.builder().config(conf).getOrCreate();
		Dataset<String> logData = spark.read().textFile("./log").cache();
		originVisitStatus = spark.read().format("orc")
				.load(Configuration.getInstance().getGraphPath() + "_orc_origin_visit_status/");
		originVisitStatus.createOrReplaceTempView("originVisitStatus");

		logger.info("Loading NodeIdMap");
		this.nodeIdMap = new NodeIdMap(Configuration.getInstance().getGraphPath());
		logger.info("Loading NodeIdMap - over");
		logger.info("Loading messages");
		this.loadMessages();
		logger.info("Loading messages - over");
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
		String resultUri = Configuration.getInstance().getExportPath() + resultFileName;

		if (ToolBox.checkIfExist(resultUri)) {
			logger.info("Loading " + resultUri);
			Type type = new TypeToken<OriginMap>() {
			}.getType();
			results = ToolBox.loadJsonObject(resultUri, type);
			logger.info("Loading " + resultUri + "Over");

		} else {

			logger.info("Computing " + resultUri);
			logger.info("Get Snapshots information from relational version");
			getSnapshotsFromRelationalVersion();
			logger.info("Export Result");
			ToolBox.exportObjectToJson(results, Configuration.getInstance().getExportPath() + resultFileName);
			logger.info("Computing " + resultUri + " over");
			spark.close();
		}

	}

	/**
	 * Get the list of OriginIdLastSnapIdOriginUri ie. for each origin retrieve its
	 * snapshot id and the corresponding timestamp
	 * 
	 * @param originIdUrlTuple A list of tuple <OriginUrl,OriginId>
	 * @return OriginMap
	 */
	private OriginMap getSnapshotsFromRelationalVersion() {
		logger.info("Retrieving Origin URL");
		List<Tuple2<String, Long>> originIdUrlTuple = origins.parallelStream().map(originId -> {
			String url = this.copy().getUrl(originId);
			return new Tuple2<String, Long>(url, originId);
		}).collect(Collectors.toList());

		logger.info("Convert  List<Tuple2<OriginUrl, originId>> to a list of Row");
		List<Row> originIdUrl = originIdUrlTuple.parallelStream().map(tuple -> RowFactory.create(tuple._1, tuple._2))
				.collect(Collectors.toList());

		logger.info("Spark processes");
		// The Schema of the new DF that will be created
		StructType schema = DataTypes.createStructType(new StructField[] {
				DataTypes.createStructField("originUrl", DataTypes.StringType, true, Metadata.empty()),
				DataTypes.createStructField("originId", DataTypes.LongType, true, Metadata.empty()) });
		// Create the dataframe
		Dataset<Row> originIdUrlDf = spark.createDataFrame(originIdUrl, schema).na().drop().cache();
		logger.info("originIdUrlDf " + originIdUrlDf.count());
		// Filter non full snapshots
		Dataset<Row> fullSnap = originVisitStatus.na().drop().where("status='full'")
				.select("snapshot", "date", "origin").cache();
		logger.info("fullSnap " + fullSnap.count());

		// Perform join and extract the corresponding List of Row
		Dataset<Row> queryRes = fullSnap
				.join(originIdUrlDf, originIdUrlDf.col("originUrl").equalTo(fullSnap.col("origin")))
				.select("snapshot", "date", "originId").groupBy("originId")
				.agg(functions.collect_list(functions.struct("snapshot", "date")).as("snapshot")).na().drop().cache();
		queryRes.coalesce(1).write().mode("overwrite").format("json")
				.save(Configuration.getInstance().getExportPath() + "test");

		queryRes.collectAsList().parallelStream().forEach(row -> {
			Long originId = row.getLong(0);
			SnapTimestampMap snaps = new SnapTimestampMap();
			NodeIdMap nodeIdMapCopy = nodeIdMap.copy();
			// Populate snaps
			row.getList(1).stream().forEach(snapRow -> {
				SWHID snapSWHID = new SWHID("swh:1:snp:" + ((Row) snapRow).getString(0));
				Long snapId = nodeIdMapCopy.getNodeId(snapSWHID, false);
				Long timestamp = ((Row) snapRow).getTimestamp(1).getTime();
				snaps.addSnap(snapId, timestamp);
			});
			synchronized (results) {
				results.addSnaps(originId, snaps);
			}
		});

		return results;
	}

	private void loadOrComputeOrigins() {
		if (ToolBox.checkIfExist(Configuration.getInstance().getExportPath() + originPath) && this.bypass) {
			logger.info("Loading Origins");
			this.origins = ToolBox.deserialize(Configuration.getInstance().getExportPath() + originPath);
			logger.info("Origins Loaded-");

		} else {
			logger.info("Computing Origins");

			try {
				if (g == null) {
					g = new Graph();
					g.loadGraph();
				}
				this.origins = new LambdaExplorer<Long, Long>(g) {
					@Override
					public void exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
						if (graphCopy.getNodeType(currentElement) == SwhType.ORI) {
							result.add(currentElement);

						}
					}

					@Override
					protected String getExportPath() {
						String uuid = UUID.randomUUID().toString();
						return Configuration.getInstance().getExportPath() + originPath;
					}
				}.explore();
				logger.info("Computing Computed - over");

			} catch (Exception e) {
				throw new RuntimeException("Error while retrieving origin");
			}
		}
	}

// **********************Inner class**********************
	public static class OriginMap {
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

	public static class SnapTimestampMap {
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
