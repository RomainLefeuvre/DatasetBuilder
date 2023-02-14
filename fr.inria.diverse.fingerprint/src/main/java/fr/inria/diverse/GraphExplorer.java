package fr.inria.diverse;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import fr.inria.diverse.tools.Configuration;
import fr.inria.diverse.tools.Executor;
import fr.inria.diverse.tools.ModelInconsistencyException;
import fr.inria.diverse.tools.ModelInconsistencyException.OriginModelInconsistencyException;
import fr.inria.diverse.tools.ToolBox;

/**
 * Class that helps to explore a graph in a parallel way with some checkpoint
 *
 * @param <T> The Result type of the graph exploration
 */
public abstract class GraphExplorer<T extends Serializable> {
	static Logger logger = LogManager.getLogger(GraphExplorer.class);
	protected Configuration config = Configuration.getInstance();
	// The graph we will explore
	protected Graph graph;
	// The semaphore used to perform thread safe checkpoint
	protected Semaphore checkpointSynchro;
	// A counter to keep the index of the exploration
	protected AtomicLong counter;
	// The result of the exploration that will be exported
	protected List<T> result;

	// Nb: you are responsible to properly initialize the result attribute in your
	// subClass
	public GraphExplorer(Graph graph) {
		this.result = Collections.synchronizedList(new ArrayList<T>());
		this.graph = graph;
		this.checkpointSynchro = new Semaphore(this.config.getThreadNumber(), true);
		this.counter = new AtomicLong(-1);
	}

	/**
	 * Explore a graph by calling exploreNodeAction for index in [0,size[ If size is
	 * the size of the graph, then the index is a nodeId and exploreNodeAction will
	 * be call for each nodeId. [Parallel exploration] The exploration is done in a
	 * parallel way via a pool of config.getThreadNumber() threads [Periodical
	 * Checkpoint ] Periodical Checkpoint are done by calling
	 * exploreGraphNodeCheckpointAction() every
	 * config.getCheckPointIntervalInMinutes() minutes
	 *
	 * @throws InterruptedException
	 */
	protected List<T> exploreGraphNode(long size) throws InterruptedException {
		Executor executor = new Executor(this.config.getThreadNumber());
		logger.info("Num of action to do : " + size);
		for (int thread = 0; thread < this.config.getThreadNumber(); thread++) {
			long finalThread = thread;
			SwhUnidirectionalGraph graphCopy = this.graph.getGraph().copy();
			executor.execute(() -> {
				Instant timestamp = Instant.now();
				Long i;
				while ((i = this.counter.incrementAndGet()) < size) {
					if (Duration.between(timestamp, Instant.now()).toMinutes() > 5) {
						timestamp = Instant.now();
						logger.info("Doing action number " + i + " over " + size + " thread " + finalThread);
					}

					try {
						this.checkpointSynchro.acquire();
						this.exploreGraphNodeAction(i, graphCopy.copy());
					} catch (OriginModelInconsistencyException e) {
						logger.debug("Inconsistency detected - Due to :" + e.getMessage());

					} catch (ModelInconsistencyException e) {
						logger.warn("Inconsistency detected - Due to :" + e.getMessage());
					} catch (Throwable e) {
						logger.error("Error catch for index " + i, e);
					}
					this.checkpointSynchro.release();

				}
			});
		}
		executor.shutdown();
		// Waiting Tasks
		while (!executor.awaitTermination(this.config.getCheckPointIntervalInMinutes(), TimeUnit.MINUTES)) {
			logger.info("Node traversal completed, waiting for asynchronous tasks. Tasks performed "
					+ executor.getCompletedTaskCount() + " over " + executor.getTaskCount());
			logger.info("Partial checkpoint, acquiring semaphore tokens");
			checkpointSynchro.acquire(this.config.getThreadNumber());
			this.exploreGraphNodeCheckpointAction();
			checkpointSynchro.release(this.config.getThreadNumber());
			logger.info("Checkpoint successfully ended, semaphore tokens released");
		}
		logger.info("Exploration done, all thread have ended, final checkpoint");
		this.exploreGraphNodeCheckpointAction();
		ToolBox.exportObjectToJson(this.result, this.getExportPath() + ".json");
		return result;
	}

	/**
	 * Function call by exploreGraphNode at iteration This function can be used to
	 * perform action directly on the graph, and use the index as a nodeId. It can
	 * also be used to iterate through a side collection ( for instance an arrayList
	 * of nodeId).
	 *
	 * @param index     the current action index (can be a nodeId)
	 * @param graphCopy the current graphCopy (thread safe approach)
	 */
	protected abstract void exploreGraphNodeAction(long index, SwhUnidirectionalGraph graphCopy);

	/**
	 * Function called peridically by exploreGraphNode to perform partial backups
	 * The current result is serialize The current counter is also serialize
	 * (current index of the exploration)
	 */
	protected void exploreGraphNodeCheckpointAction() {
		ToolBox.serialize(this.result, this.getExportPath().toString());
		ToolBox.serialize(this.counter, this.getExportCounterPath().toString());

	}

	/**
	 * Try to restore previous explorer state by restoring the results and the
	 * counter
	 */
	protected void restoreCheckpoint() {
		// Try to restore previous partial experiment
		List<T> checkpointResult = ToolBox.deserialize(this.getExportPath().toString());
		AtomicLong checkpointCounter = ToolBox.deserialize(this.getExportCounterPath().toString());
		if (checkpointCounter == null || checkpointCounter.get() == 0 || checkpointResult == null) {
			logger.info("No checkpoint to restart from");
		} else {
			logger.info("Checkpoint found, restart from it, start at node " + checkpointCounter.get());
			this.counter = checkpointCounter;
			this.result = Collections.synchronizedList(checkpointResult);
		}
	}

	protected abstract Path getExportPath();

	protected Path getExportCounterPath() {
		return Paths.get(this.getExportPath().toString() + "_state");
	}

	public void run() throws InterruptedException, IOException {
		try {
			this.restoreCheckpoint();
			this.exploreGraphNode(graph.getGraph().numNodes());
		} catch (Exception e) {
			logger.error("Error while running ", e);
			throw new RuntimeException("Error", e);
		}
	}

}