package fr.inria.diverse.model;

import it.unimi.dsi.big.webgraph.labelling.ArcLabelledNodeIterator.LabelledArcIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import org.softwareheritage.graph.labels.DirEntry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Directory extends NodeImpl implements DirectoryChild, Serializable {
	static Logger logger = LogManager.getLogger(Directory.class);

	public Directory() {
		super();
	}

	public Directory(long nodeId, SwhUnidirectionalGraph g) {
		super(nodeId, g);
	}

	public List<DirectoryEntry> getEntries() {
		List<DirectoryEntry> entries = new ArrayList<>();
		SwhUnidirectionalGraph graphCopy = this.getGraph().copy();
		LabelledArcIterator it = graphCopy.labelledSuccessors(this.getNodeId());
		for (long childId; (childId = it.nextLong()) >= 0;) {
			DirectoryChild child = null;
			switch (graphCopy.getNodeType(childId)) {
			case DIR: {
				child = new Directory(childId, this.getGraph());
				break;
			}
			case CNT: {
				child = new Content(childId, this.getGraph());
				break;
			}
			case REV: {
				child = new Revision(childId, this.getGraph());
				break;
			}
			default:
				logger.warn("Cannot instanciate properly the entry " + childId);
			}
			DirEntry[] labels = (DirEntry[]) it.label().get();
			// A child can have multiple label ie, the same node is present multiple time in
			// the folder under different name
			// e.g. it can contain multiple empty file
			for (DirEntry label : labels) {
				String entryName = new String(graphCopy.getLabelName(label.filenameId));
				entries.add(new DirectoryEntry(child, entryName));
			}
		}
		return entries;
	}
}
