package fr.inria.diverse.tools;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.maps.NodeIdMap;
import org.softwareheritage.graph.maps.NodeTypesMap;

import com.google.gson.reflect.TypeToken;

import fr.inria.diverse.Graph;
import fr.inria.diverse.LambdaExplorer;
import fr.inria.diverse.query.GraphQueryRunner;
import it.unimi.dsi.fastutil.bytes.ByteBigList;
import it.unimi.dsi.fastutil.bytes.ByteMappedBigList;
import it.unimi.dsi.fastutil.longs.LongBigList;
import it.unimi.dsi.fastutil.longs.LongMappedBigList;
import it.unimi.dsi.fastutil.shorts.ShortBigList;
import it.unimi.dsi.fastutil.shorts.ShortMappedBigList;
import picocli.CommandLine;
import picocli.CommandLine.PropertiesDefaultProvider;

/*Class that contains all the different treatments, function needed to integrate
the last visit of each origin. In fact, it is realy usefull to access such kind of information to build
efficient query on the graph. Here we will not integrate it in the most efficient manner, as it is preferable
to do it directly in the generation of the compressed version of the PropertyGraphDataset.
*/
public class OriginToolbox extends SwhGraphProperties {
	static Logger logger = LogManager.getLogger(OriginToolbox.class);
	static String resultFileName= "OriginIdLastSnapIdOriginUri.json";
	static String originLastSnapFileName = "originLastSnap.json";
	//ToDo : use a different way to store data, more space efficient
	private HashMap<String,Long> originUriLastSnapId;
	private List<OriginIdLastSnapIdOriginUri> results;


	List<List<String>> lastVisits;
	private List<Long> origins;

	public OriginToolbox() throws IOException {
		this(ToolBox.deserialize(Configuration.getInstance().getExportPath() +"origins/origins"));
	}
	
	public OriginToolbox(List<Long> origins) throws IOException {
		super(Configuration.getInstance().getGraphPath());
		logger.info("Loading NodeIdMap");
		this.nodeIdMap=new NodeIdMap(Configuration.getInstance().getGraphPath());
		logger.info("Loading NodeIdMap - over");
		logger.info("Loading messages");
		this.loadMessages();
		logger.info("Loading messages - over");
		logger.info("Loading lastVisits");
		this.lastVisits= ToolBox.readCsv(Configuration.getInstance().getGraphPath() + ".lastVisit.csv");
		logger.info("Loading lastVisits - over");
		logger.info("Loading origins");
		this.origins = origins;
		logger.info("Loading origins - over");
        results= new ArrayList<>();
        originUriLastSnapId =  new HashMap<>();
	}

	// Use the mph function to get the corresponding swhid, since our swhid are
	// extract
	// from the relation version we assume that the corresponding id exists
	public void run() {
		logger.info("Populate originUriLastSnapId");
		for (List<String> l : lastVisits) {
			try {
				originUriLastSnapId.put(l.get(0), this.nodeIdMap.getNodeId(new SWHID("swh:1:snp:" + l.get(2)), false));
			} catch (Exception e) {
				logger.warn("error while retrieving last visit " + l,e);
			}
		}
		logger.info("Populate OriginIdLastSnapId");
		for(Long originId : origins) {
			String url = this.getUrl(originId);
			if(this.originUriLastSnapId.containsKey(url)) {
				Long lastSnapId= this.originUriLastSnapId.get(url);
				this.results.add(new OriginIdLastSnapIdOriginUri(lastSnapId,url,originId));

			}else {
				logger.warn("Skipping "+originId+" "+url);
			}
		}
		logger.info("Export Result");
		ToolBox.exportObjectToJson(results,  Configuration.getInstance().getExportPath() +resultFileName);
	}
	
	public static class OriginIdLastSnapIdOriginUri{
		private Long originId;
		private Long lastSnapId;
		private String originUri;
		public OriginIdLastSnapIdOriginUri(Long lastSnapId, String originUri, Long originId) {
			super();
			this.originId=originId;
			this.lastSnapId = lastSnapId;
			this.originUri = originUri;
		}
		public Long getOriginId() {
			return originId;
		}
		public void setOriginId(Long originId) {
			this.originId = originId;
		}
		public Long getLastSnapId() {
			return lastSnapId;
		}
		public void setLastSnapId(Long lastSnapId) {
			this.lastSnapId = lastSnapId;
		}
		public String getOriginUri() {
			return originUri;
		}
		public void setOriginUri(String originUri) {
			this.originUri = originUri;
		}
		
		
	}

	public List<OriginIdLastSnapIdOriginUri> getResults() {
		return results;
	}
	
	public static Map<Long, OriginIdLastSnapIdOriginUri> loadOrComputeLastSnaps(List<Long> origins) {
		List<OriginIdLastSnapIdOriginUri> results;
		String resultUri =  Configuration.getInstance().getExportPath() + resultFileName;
		if(ToolBox.checkIfExist(resultUri)) {
			logger.info("Loading " + resultUri);
			Type type = new TypeToken<List<OriginIdLastSnapIdOriginUri>> () {
            }.getType();
            results =ToolBox.loadJsonObject(resultUri, type);
			logger.info("Loading " + resultUri+" ");

		}else {
			results=computeLastSnaps(origins);
		}
		return results.stream().collect(Collectors.toMap(OriginIdLastSnapIdOriginUri::getOriginId, Function.identity()));

		
	}
	public static Map<Long, OriginIdLastSnapIdOriginUri> loadOrComputeLastSnaps() {
		return loadOrComputeLastSnaps();
		
	}
	public static List<OriginIdLastSnapIdOriginUri> computeLastSnaps(List<Long> origins) {
		List<OriginIdLastSnapIdOriginUri> results;
		String resultUri =  Configuration.getInstance().getExportPath() + resultFileName;
		
			try {
				logger.info("Computing " + resultUri);
				OriginToolbox l = new OriginToolbox(origins);
				l.run();
				results=l.getResults();
				logger.info("Computing " + resultUri+" over");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		return results;

		
	}
	public static class  Runner extends GraphQueryRunner {
		@Override
		public void run() {
			logger.info("Origin Toolbox");

			computeLastSnaps(ToolBox.deserialize(Configuration.getInstance().getExportPath() +"origins/origins"));

		}
		
	}
 
	public static void main(String[] args) throws IOException, InterruptedException {
		Runner runner =new Runner();
    	runner.init();
    	runner.execute(new String[0]);
					
    }
	
}
