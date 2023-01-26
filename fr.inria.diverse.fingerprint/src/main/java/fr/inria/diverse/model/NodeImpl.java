package fr.inria.diverse.model;

import org.softwareheritage.graph.SwhUnidirectionalGraph;

import java.io.Serializable;

public class NodeImpl implements Serializable, Node {
    private static final long serialVersionUID = -5583517045537897698L;
    private long nodeId;
    private String swhid;
    private SwhUnidirectionalGraph graph;


    public NodeImpl() {
    }

    public NodeImpl(long nodeId, SwhUnidirectionalGraph g) {
        this.graph=g;
        this.nodeId = nodeId;
    }

    public String getSwhid() {
        if(swhid==null){
            this.swhid= String.valueOf(this.graph.getSWHID(this.nodeId));
        }
        return swhid;
    }

    public void setSwhid(String swhid) {
        this.swhid = swhid;
    }

    public SwhUnidirectionalGraph getGraph() {
        return graph;
    }

    public void setGraph(SwhUnidirectionalGraph g) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeImpl node = (NodeImpl) o;

        return nodeId == node.nodeId;
    }

    @Override
    public int hashCode() {
        return (int) (nodeId ^ (nodeId >>> 32));
    }
}
