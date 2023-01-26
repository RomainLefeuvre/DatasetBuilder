package fr.inria.diverse;

import fr.inria.diverse.tools.Configuration;
import fr.inria.diverse.tools.ToolBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    static Logger logger = LogManager.getLogger(Graph.class);
    protected SwhUnidirectionalGraph graph;
    protected Configuration config = Configuration.getInstance();
    protected List<Long> origins;
    public static Set<Long> lastSnap = new HashSet<>();
    /**
     * Load the transposed Graph
     */
    public void loadGraph() throws IOException {
        logger.info("Loading graph " + (this.isMappedMemoryActivated() ? "MAPPED MODE" : ""));
        graph = this.isMappedMemoryActivated() ?
                SwhUnidirectionalGraph.loadLabelledMapped(this.config.getGraphPath()) :
                SwhUnidirectionalGraph.loadLabelled(this.config.getGraphPath());
        graph.loadCommitterTimestamps();
        //graph.loadAuthorTimestamps();
        logger.info("Graph loaded");
        logger.info("Loading message");
        graph.properties.loadMessages();
        logger.info("Message loaded");
        logger.info("Loading label");
        graph.properties.loadLabelNames();
        logger.info("Label loaded");
        loadLastVisit();
        logger.info("Last visit Loaded");

    }

    private boolean isMappedMemoryActivated() {
        return this.config.getLoadingMode().equals("MAPPED");
    }

    public SwhUnidirectionalGraph getGraph() {
        return graph;
    }

    public void setGraph(SwhUnidirectionalGraph graph) {
        this.graph = graph;
    }

    public List<Long> getOrigins() {
        if(origins==null){
            logger.info("------Loading Origins------");
            try {
                origins = new LambdaExplorer<Long, Long>(this) {
                    @Override
                    public void exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
                        if (graphCopy.getNodeType(currentElement) == SwhType.ORI) {
                            synchronized (result) {
                                result.add(currentElement);
                            }
                        }
                    }
                    @Override
                    protected String getExportPath() {
                        String uuid = UUID.randomUUID().toString();
                        return Configuration.getInstance()
                                .getExportPath() +"origins/origins";
                    }
                }.explore();
                logger.info("------Origins Loaded------");

            } catch (Exception e) {
                throw new RuntimeException("Error while retrieving origin");
            }
        }
        return origins;
    }

    public void loadLastVisit(){
        List<List<String>> lastVisits = ToolBox.readCsv(Configuration.getInstance().getGraphPath()+".lastVisit.csv");
        for(List<String> l : lastVisits){
            try {
                lastSnap.add(this.graph.getNodeId(new SWHID("swh:1:snp:" + l.get(2))));
            }catch(Exception e){
                logger.warn("error while retrieving last visit "+ l);
            }
        }
    }



}
