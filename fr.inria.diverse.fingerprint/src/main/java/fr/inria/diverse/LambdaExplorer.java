package fr.inria.diverse;

import fr.inria.diverse.model.Origin;
import fr.inria.diverse.tools.Configuration;
import it.unimi.dsi.big.webgraph.ImmutableGraph;
import it.unimi.dsi.big.webgraph.LazyLongIterator;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public abstract class LambdaExplorer<Input,Output extends Serializable> extends GraphExplorer<Output>{
    protected List<Input> inputs;
    protected String exportName="";
    public LambdaExplorer(Graph graph) {
        super(graph);
    }



    public LambdaExplorer(Graph graph, List<Input> inputs){
        super(graph);
        this.inputs=inputs;
    }
    public LambdaExplorer(Graph graph, List<Input> inputs,String exportName){
        super(graph);
        this.inputs=inputs;
        this.exportName=exportName;
    }

    private Class<Input> getParameterClass() {
        return (Class<Input>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    protected void exploreGraphNodeAction(long index, SwhUnidirectionalGraph graphCopy) {
        if(inputs!=null){
            //ToDo Fix it to work with big inputs, here it's cat to an int ..
            exploreGraphNodeActionOnElement(inputs.get((int) index),graphCopy);
        }else if(getParameterClass().equals(Long.class)){
            exploreGraphNodeActionOnElement((Input) new Long(index),graphCopy);
        }

    }
    public abstract void exploreGraphNodeActionOnElement(Input currentElement, SwhUnidirectionalGraph graphCopy);

    @Override
    protected String getExportPath() {
        return Configuration.getInstance()
                .getExportPath() +exportName+"/"+exportName;
    }

    @Override
    public void run() throws InterruptedException, IOException {
        try {
            this.restoreCheckpoint();
            this.exploreGraphNode(this.inputs!=null ?inputs.size():graph.getGraph().numNodes());
        } catch (Exception e) {
            logger.error("Error while running ",e);
            throw new RuntimeException("Error", e);
        }    }

    public List<Output> explore() throws InterruptedException, IOException {
        this.run();
        logger.info("found "+result.size()+" results");
        return result;
    }

    public static void visitNodesBFS(ImmutableGraph graph, long srcNodeId) {
        Queue<Long> queue = new ArrayDeque<>();
        HashSet<Long> visited = new HashSet<Long>();
        queue.add(srcNodeId);
        visited.add(srcNodeId);

        while (!queue.isEmpty()) {
            long currentNodeId = queue.poll();
            System.out.println(currentNodeId);

            LazyLongIterator it = graph.successors(currentNodeId);
            for (long neighborNodeId; (neighborNodeId = it.nextLong()) != -1;) {
                if (!visited.contains(neighborNodeId)) {
                    queue.add(neighborNodeId);
                    visited.add(neighborNodeId);
                }
            }
        }
    }

    ;


}
