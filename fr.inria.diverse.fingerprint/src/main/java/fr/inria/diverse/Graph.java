package fr.inria.diverse;

import fr.inria.diverse.tools.Configuration;
import fr.inria.diverse.tools.ToolBox;
import fr.inria.diverse.tools.OriginToolbox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    static Logger logger = LogManager.getLogger(Graph.class);
    protected SwhUnidirectionalGraph graph;
    protected Configuration config = Configuration.getInstance();
    protected List<Long> origins;
    public static  Map<Long, OriginToolbox.OriginIdLastSnapIdOriginUri>  lastSnap;
    /**
     * Load the transposed Graph
     */
    public void loadGraph() throws IOException {
        logger.info("Loading graph " + (this.isMappedMemoryActivated() ? "MAPPED MODE" : ""));
        logger.info("Loading origins");
        this.loadOrigins();
        logger.info("Origins loaded");
        logger.info("Loading Last visit");
        lastSnap= OriginToolbox.loadOrComputeLastSnaps(origins);
        logger.info("Last visit Loaded");
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
        logger.info("Loading origins");
        this.loadOrigins();
        logger.info("Origins loaded");
        logger.info("Loading Last visit");
        lastSnap= OriginToolbox.loadOrComputeLastSnaps(origins);
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
    
    public List<Long> getOrigins(){
    	return this.origins;
    }

    private void loadOrigins() {
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
    }
    
    

  



}
