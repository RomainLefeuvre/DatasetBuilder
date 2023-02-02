package fr.inria.diverse.tools;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.maps.NodeIdMap;
import org.softwareheritage.graph.maps.NodeTypesMap;

import fr.inria.diverse.Graph;
import it.unimi.dsi.fastutil.bytes.ByteBigList;
import it.unimi.dsi.fastutil.bytes.ByteMappedBigList;
import it.unimi.dsi.fastutil.longs.LongBigList;
import it.unimi.dsi.fastutil.longs.LongMappedBigList;
import it.unimi.dsi.fastutil.shorts.ShortBigList;
import it.unimi.dsi.fastutil.shorts.ShortMappedBigList;

/*Class that contains all the different treatments, function needed to integrate
the last visit of each origin. In fact, it is realy usefull to access such kind of information to build
efficient query on the graph. Here we will not integrate it in the most efficient manner, as it is preferable
to do it directly in the generation of the compressed version of the PropertyGraphDataset.
*/
public class LastVisits extends SwhGraphProperties {
	static Logger logger = LogManager.getLogger(LastVisits.class);
	static String originLastSnapUri = Configuration.getInstance().getExportPath() + "originLastSnap.json";
	//ToDo : use a different way to store data, more space efficient
	private HashMap<String,Long> originUriLastSnapId;
	private List<OriginIdLastSnapIdOriginUri> results;

	List<List<String>> lastVisits;
	private Set<Long> origins;

	public LastVisits() throws IOException {
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
		this.origins = ToolBox.deserialize(Configuration.getInstance().getExportPath() +"origins/origins");
		logger.info("Loading origins - over");
        results= new ArrayList<>();
		
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
				logger.warn("error while retrieving last visit " + l);
			}
		}
		logger.info("Populate OriginIdLastSnapId");
		for(Long originId : origins) {
			String url = this.getUrl(originId);
			Long lastSnapId= this.originUriLastSnapId.get(url);
			this.results.add(new OriginIdLastSnapIdOriginUri(lastSnapId,url,originId));
		}
		logger.info("Export Result");
		ToolBox.exportObjectToJson(results, Configuration.getInstance().getExportPath() + "OriginIdLastSnapIdOriginUri.json");
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
 
	public static void main(String[] args) throws IOException, InterruptedException {
		LastVisits lastVisit = new LastVisits();
		lastVisit.run();
			
    }
	
}
