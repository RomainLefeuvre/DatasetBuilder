package fr.inria.diverse.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.labels.DirEntry;

import fr.inria.diverse.Graph;
import it.unimi.dsi.big.webgraph.labelling.ArcLabelledNodeIterator;

public class Snapshot extends NodeImpl implements Serializable {
	private static final long serialVersionUID = 2166967946176031738L;
	static Logger logger = LogManager.getLogger(Snapshot.class);
	private List<SnapshotBranch> branches;

	public Snapshot() {
	}

	public Snapshot(long nodeId, Graph g) {
		super(nodeId, g);
	}

	public List<SnapshotBranch> getBranches() {
		if (this.branches == null) {
			this.branches = new ArrayList<>();
			SwhUnidirectionalGraph graphCopy = this.getUnderlyingGraph().copy();
			ArcLabelledNodeIterator.LabelledArcIterator it = graphCopy.labelledSuccessors(this.getNodeId());
			for (long snapChildId; (snapChildId = it.nextLong()) != -1;) {
				final DirEntry[] labels = (DirEntry[]) it.label().get();
				DirEntry label = labels[0];
				String branchName = new String(graphCopy.getLabelName(label.filenameId));
				SnapshotChild snapChild = null;
				switch (graphCopy.getNodeType(snapChildId)) {
				case REV: {
					snapChild = new Revision(snapChildId, this.getGraph());
					break;
				}
				case REL: {
					snapChild = new Release(snapChildId, this.getGraph());
					break;
				}
				}
				if (snapChild != null) {
					this.branches.add(new SnapshotBranch(branchName, snapChild));
				} else {
					logger.warn("Branch skipped since child cannot be init for child id " + snapChildId);
				}

			}
		}
		return branches;
	}

	public void setBranches(List<SnapshotBranch> branches) {
		this.branches = branches;
	}
}
