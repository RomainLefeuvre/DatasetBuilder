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
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.storage.StorageLevel;
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
the last visit of each origin. In fact, it is realy usefull to access such kind of information to build
efficient query on the graph. Here we will not integrate it in the most efficient manner, as it is preferable
to do it directly in the generation of the compressed version of the PropertyGraphDataset.
*/
public class OriginToolbox extends SwhGraphProperties {
	static Logger logger = LogManager.getLogger(OriginToolbox.class);
	static String resultFileName = "originsSnaps.json";
	String originPath = "origins/origins";

	// ToDo : use a different way to store data, more space efficient
	private HashMap<String, Long> originUriLastSnapId;
	private OriginMap results;
	private SparkSession spark;
	private Graph g;
	Dataset<Row> originVisitStatus;
	private List<Long> origins;
	// Bypass origin termination check to avoid graph loading
	private Boolean bypass = false;

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
		SparkConf conf = new SparkConf().setMaster("local[" + totalThread + "]").setAppName("dataSetBuilder")
				.set("spark.driver.memory", "" + Runtime.getRuntime().freeMemory());
		spark = SparkSession.builder().config(conf).getOrCreate();
		Dataset<String> logData = spark.read().textFile("./log").cache();
		originVisitStatus = spark.read().format("orc")
				.load(Configuration.getInstance().getGraphPath() + "_orc_origin_visit_status/");
		originVisitStatus.createOrReplaceTempView("originVisitStatus");
		originVisitStatus.persist(StorageLevel.MEMORY_ONLY());
		logger.info("OriginVisistStatus Loaded, " + originVisitStatus.count() + " rows");

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
			logger.info("Loading " + resultUri + " ");

		} else {

			logger.info("Computing " + resultUri);
			logger.info("Get Snapshots information from relational version");
			List<Tuple2<String, Long>> originIdUrlTuple = origins.parallelStream().map(originId -> {
				String url = this.copy().getUrl(originId);
				return new Tuple2<String, Long>(url, originId);
			}).collect(Collectors.toList());
			results = getSnapshotsFromRelationalVersion(originIdUrlTuple);

			logger.info("Export Result");
			ToolBox.exportObjectToJson(results, Configuration.getInstance().getExportPath() + resultFileName);
			logger.info("Computing " + resultUri + " over");

		}

	}

	/**
	 * Get the list of OriginIdLastSnapIdOriginUri ie. for each origin retrieve its
	 * snapshot id and the corresponding timestamp
	 * 
	 * @param originIdUrlTuple A list of tuple <OriginUrl,OriginId>
	 * @return List<OriginIdLastSnapIdOriginUri>
	 */
	private OriginMap getSnapshotsFromRelationalVersion(List<Tuple2<String, Long>> originIdUrlTuple) {
		// Convert the hashmap to a list of Row
		List<Row> originIdUrl = originIdUrlTuple.parallelStream().map(tuple -> RowFactory.create(tuple._1, tuple._2))
				.collect(Collectors.toList());
		// The Schema of the new DF that will be created
		StructType schema = DataTypes.createStructType(
				new StructField[] { DataTypes.createStructField("originUrl", DataTypes.StringType, false),
						DataTypes.createStructField("originId", DataTypes.LongType, false) });
		// Create the dataframe
		Dataset<Row> originIdUrlDf = spark.createDataFrame(originIdUrl, schema);
		// Filter non full snapshots
		Dataset<Row> fullRow = originVisitStatus.select("snapshot", "date", "origin").filter("status='full'");
		// Perform join and extract the corresponding List of Row
		List<Row> queryRes = fullRow.join(originIdUrlDf, originIdUrlDf.col("originUrl").equalTo(fullRow.col("origin")))
				.select("snapshot", "date", "originId").collectAsList();
		// Convert the list of Row to an HashMap <OriginId,<SnapId,SnapTimestamp>>
		OriginMap result = new OriginMap();
		queryRes.parallelStream().forEach(row -> {
			Long snapId = this.nodeIdMap.copy().getNodeId(new SWHID("swh:1:snp:" + row.getString(0)), false);
			Long timestamp = row.getTimestamp(1).getTime();
			Long originId = row.getLong(2);
			synchronized (result) {
				result.addSnap(originId, new Tuple2<Long, Long>(snapId, timestamp));
			}
		});

		return result;
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
