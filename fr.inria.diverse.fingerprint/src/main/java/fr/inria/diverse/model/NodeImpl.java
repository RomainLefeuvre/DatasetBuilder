package fr.inria.diverse.model;

import java.io.Serializable;

import org.softwareheritage.graph.SwhUnidirectionalGraph;

import fr.inria.diverse.Graph;

public class NodeImpl implements Serializable, Node {
	private static final long serialVersionUID = -5583517045537897698L;
	private long nodeId;
	private String swhid;
	private Graph graph;

	public NodeImpl() {
	}

	public NodeImpl(long nodeId, Graph g) {
		this.graph = g;
		this.nodeId = nodeId;
	}

	public String getSwhid() {
		if (swhid == null) {
			this.swhid = String.valueOf(this.getUnderlyingGraph().getSWHID(this.nodeId));
		}
		return swhid;
	}

	public void setSwhid(String swhid) {
		this.swhid = swhid;
	}

	public SwhUnidirectionalGraph getUnderlyingGraph() {
		return graph.getGraph();
	}

	@Override
	public Graph getGraph() {
		return graph;
	}

	@Override
	public void setGraph(Graph g) {
		this.graph = g;
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		NodeImpl node = (NodeImpl) o;

		return nodeId == node.nodeId;
	}

	@Override
	public int hashCode() {
		return (int) (nodeId ^ (nodeId >>> 32));
	}

}
