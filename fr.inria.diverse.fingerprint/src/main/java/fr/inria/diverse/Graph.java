package fr.inria.diverse;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import fr.inria.diverse.tools.Configuration;
import fr.inria.diverse.tools.OriginToolbox;
import fr.inria.diverse.tools.OriginToolbox.OriginMap;

public class Graph {
	static Logger logger = LogManager.getLogger(Graph.class);
	protected SwhUnidirectionalGraph graph;
	protected Configuration config = Configuration.getInstance();
	protected List<Long> originsList;
	public static OriginMap originsSnaps;

	/**
	 * Load the transposed Graph
	 */
	public void loadGraph() throws IOException {
		logger.info("Loading graph " + (this.isMappedMemoryActivated() ? "MAPPED MODE" : ""));
		graph = this.isMappedMemoryActivated() ? SwhUnidirectionalGraph.loadLabelledMapped(this.config.getGraphPath())
				: SwhUnidirectionalGraph.loadLabelled(this.config.getGraphPath());
		graph.loadCommitterTimestamps();
		// graph.loadAuthorTimestamps();
		logger.info("Graph loaded");
		logger.info("Loading message");
		graph.properties.loadMessages();
		logger.info("Message loaded");
		logger.info("Loading label");
		graph.properties.loadLabelNames();
		logger.info("Label loaded");
		logger.info("Loading Origins");

	}

	public void loadExternalInfo() throws IOException {
		OriginToolbox t = new OriginToolbox(this);
		t.run();
		this.originsList = t.getOrigins();
		this.originsSnaps = t.getResults();
		logger.info("Origins Loaded");
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
		return this.originsList;
	}

}
