package fr.inria.diverse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.inria.diverse.Graph;
import fr.inria.diverse.tools.ModelInconsistencyException;
import fr.inria.diverse.tools.OriginToolbox.SnapTimestampMap;
import it.unimi.dsi.big.webgraph.LazyLongIterator;

public class Origin extends NodeImpl implements Serializable {
	private static final long serialVersionUID = -7579546333573935591L;
	static Logger logger = LogManager.getLogger(Origin.class);
	private List<OriginVisit> originVisits;
	private OriginVisit lastVisit;
	private String originUrl;

	public Origin() {
	}

	public Origin(long nodeId, Graph g) {
		super(nodeId, g);
		this.originUrl = originUrl;
	}

	/**
	 * Get the List of the full Origin visit that are prior to the query timestamp
	 * 
	 * @return List<OriginVisit>
	 */
	public List<OriginVisit> getOriginVisits() {

		if (originVisits == null) {
			this.originVisits = new ArrayList<>();
			LazyLongIterator it = this.getUnderlyingGraph().copy().successors(this.getNodeId());
			SnapTimestampMap snaps = this.getGraph().getOriginsSnaps().getSnaps(this.getNodeId());
			if (snaps != null) {
				for (long snapId; (snapId = it.nextLong()) != -1;) {
					Long snapTimestamp = snaps.getTimestamp(snapId);

					if (snapTimestamp != null) {
						if (snapTimestamp <= this.getGraph().getConfig().getQueryTimestamp().toInstant().toEpochMilli()
								&& snapTimestamp <= this.getGraph().getGraphTimestamp().toInstant().toEpochMilli()) {
							originVisits.add(new OriginVisit(new Snapshot(snapId, this.getGraph()), snapTimestamp));
						} else {
							logger.info(
									"Skipping origin visit containing snap " + snapId + " since the query date is ");
						}
					} else {
						throw new ModelInconsistencyException(
								"Snap " + snapId + " not found for origin " + this.getNodeId());
					}
				}
			} else {
				throw new ModelInconsistencyException("No full originVisit for " + this.getNodeId());
			}
		}
		return originVisits;
	}

	public OriginVisit getLastOriginVisit() {
		return this.getOriginVisits().stream().max(Comparator.comparing(OriginVisit::getTimestamp))
				.orElseThrow(() -> new ModelInconsistencyException("No full originVisit for " + this.getNodeId()));
	}

	public void setOriginVisit(List<OriginVisit> originVisit) {
		this.originVisits = originVisit;
	}

	public String getOriginUrl() {
		if (originUrl == null) {
			originUrl = this.getUnderlyingGraph().copy().getUrl(this.getNodeId());
		}
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

}
