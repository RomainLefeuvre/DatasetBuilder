package fr.inria.diverse.model;

import fr.inria.diverse.Graph;

public class Content extends NodeImpl implements DirectoryChild {
	private static final long serialVersionUID = 5000328769363386292L;

	public Content() {
	}

	public Content(long nodeId, Graph g) {
		super(nodeId, g);
	}

	public long getLength() {
		return this.getUnderlyingGraph().copy().getContentLength(this.getNodeId());
	}
}
