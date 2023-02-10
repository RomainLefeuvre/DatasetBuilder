package fr.inria.diverse.model;

import org.softwareheritage.graph.SwhUnidirectionalGraph;

import fr.inria.diverse.Graph;

public interface Node {
	public long getNodeId();

	public String getSwhid();

	public void setSwhid(String swhid);

	public SwhUnidirectionalGraph getUnderlyingGraph();

	public Graph getGraph();

	public void setGraph(Graph g);

	public void setNodeId(long nodeId);
}
