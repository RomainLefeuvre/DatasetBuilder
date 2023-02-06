package fr.inria.diverse.model;

import fr.inria.diverse.Graph;
import fr.inria.diverse.tools.ModelInconsistencyException;
import fr.inria.diverse.tools.OriginToolbox;
import it.unimi.dsi.big.webgraph.LazyLongIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Origin extends NodeImpl implements Serializable {
	private static final long serialVersionUID = -7579546333573935591L;
	static Logger logger = LogManager.getLogger(Origin.class);
	private List<OriginVisit> originVisits;
	private OriginVisit lastVisit;
	private String originUrl;

	public Origin() {
	}

	public Origin(long nodeId, SwhUnidirectionalGraph g) {
		super(nodeId, g);
		this.originUrl = originUrl;
	}

	public List<OriginVisit> getOriginVisits() {

		if (originVisits == null) {
			this.originVisits = new ArrayList<>();
			LazyLongIterator it = this.getGraph().copy().successors(this.getNodeId());
			for (long childId; (childId = it.nextLong()) != -1;) {
				originVisits.add(new OriginVisit(new Snapshot(childId, this.getGraph())));
			}
		}
		// Todo Restore it from a file
		return originVisits;
	}

	public OriginVisit getLastVisit()   {
		if(lastVisit==null)
			loadOriginIdLastSnapIdOriginUri();
		if(lastVisit==null)
		throw new ModelInconsistencyException("Last Visit not available for origin node " + this.getNodeId());
		return lastVisit;
	}
	
	protected void loadOriginIdLastSnapIdOriginUri()  {		
		    if(Graph.lastSnap.containsKey(this.getNodeId())) {
				OriginToolbox.OriginIdLastSnapIdOriginUri o =Graph.lastSnap.get(this.getNodeId());
				if(o==null) {
					throw new ModelInconsistencyException("Cannot find last Snap for given origin "+this.getNodeId());
				}
				if(o!=null && o.getLastSnapId()!=null)
					this.lastVisit=new OriginVisit(new Snapshot(o.getLastSnapId(), this.getGraph()));
				if(o!=null && o.getOriginUri()!=null)
					this.originUrl=o.getOriginUri();
		    }else {
				throw new ModelInconsistencyException("Cannot find last Snap for given origin "+this.getNodeId());

		    }
	}

	public void setOriginVisit(List<OriginVisit> originVisit) {
		this.originVisits = originVisit;
	}

	public String getOriginUrl() {
		if (originUrl == null) {
			originUrl = this.getGraph().copy().getUrl(this.getNodeId());
		}
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}
}
