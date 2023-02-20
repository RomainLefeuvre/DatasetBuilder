package fr.inria.diverse;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.softwareheritage.graph.SwhUnidirectionalGraph;

import fr.inria.diverse.tools.Configuration;

/**
 * An extension to graph explorer that handle input list properly
 *
 * @param <Input>  The type of input element such that inputs is an List<Input>
 * @param <Output> The type of result element such that result is a List<Output>
 */
public abstract class LambdaExplorer<Input, Output extends Serializable> extends GraphExplorer<Output> {
	protected List<Input> inputs;
	protected String exportName = "";

	public LambdaExplorer(Graph graph) {
		super(graph);
	}

	public LambdaExplorer(Graph graph, List<Input> inputs) {
		super(graph);
		this.inputs = inputs;
	}

	public LambdaExplorer(Graph graph, List<Input> inputs, String exportName) {
		super(graph);
		this.inputs = inputs;
		this.exportName = exportName;
	}

	private Class<Input> getParameterClass() {
		return (Class<Input>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	protected Output exploreGraphNodeAction(long index, SwhUnidirectionalGraph graphCopy) {
		if (inputs != null) {
			// ToDo Fix it to work with big inputs, here it's cat to an int ..
			return exploreGraphNodeActionOnElement(inputs.get((int) index), graphCopy);
		} else if (getParameterClass().equals(Long.class)) {
			return exploreGraphNodeActionOnElement((Input) new Long(index), graphCopy);
		}
		throw new RuntimeException("Input error");
	}

	public abstract Output exploreGraphNodeActionOnElement(Input currentElement, SwhUnidirectionalGraph graphCopy);

	@Override
	protected Path getExportPath() {
		return Paths.get(Configuration.getInstance().getExportPath().toString(), exportName, exportName);
	}

	@Override
	public void run() throws InterruptedException, IOException {
		this.run(true, 1000L);
	}

	public void run(boolean restoreCheckpoint, Long batchSize) throws InterruptedException, IOException {
		try {
			if (restoreCheckpoint)
				this.restoreCheckpoint();
			this.exploreGraphNode(this.inputs != null ? inputs.size() : graph.getGraph().numNodes(), batchSize);
		} catch (Exception e) {
			logger.error("Error while running ", e);
			throw new RuntimeException("Error", e);
		}
	}

	public List<Output> explore() throws InterruptedException, IOException {
		return this.explore(true, 1000L);
	}

	public List<Output> explore(boolean restoreCheckpoint, Long batchSize) throws InterruptedException, IOException {
		this.run(restoreCheckpoint, batchSize);
		logger.info("found " + result.size() + " results");
		return result;
	}
}
