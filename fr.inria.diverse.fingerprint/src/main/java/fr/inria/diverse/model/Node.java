package fr.inria.diverse.model;

import org.softwareheritage.graph.SwhUnidirectionalGraph;

public interface Node {
    public long getNodeId();

    public String getSwhid();
    public void setSwhid(String swhid);
    public SwhUnidirectionalGraph getGraph();
    public void setGraph(SwhUnidirectionalGraph g);
    public void setNodeId(long nodeId);
}
