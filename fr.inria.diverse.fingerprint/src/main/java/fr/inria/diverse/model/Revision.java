package fr.inria.diverse.model;

import it.unimi.dsi.big.webgraph.LazyLongIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import java.io.Serializable;

public class Revision extends NodeImpl implements Serializable, SnapshotChild, DirectoryChild {
	private static final long serialVersionUID = 6380145784930210887L;
	private Long commiterTimestamp;
	private Long timestamp;
	private String commiter;
	private String message;
	private String author;
	static Logger logger = LogManager.getLogger(Revision.class);

	public Revision() {
		super();
	}

	public Revision(long nodeId, SwhUnidirectionalGraph g) {
		super(nodeId, g);
	}

	public int compareTo(@NotNull Revision rev) {
		return this.getCommiterTimestamp().compareTo(rev.getCommiterTimestamp());
	}

	public Long getCommiterTimestamp() {
		if (this.commiterTimestamp == null) {
			this.commiterTimestamp = this.getGraph().copy().getCommitterTimestamp(this.getNodeId());
			if (this.commiterTimestamp == null) {
				throw new RuntimeException("No commiter timestamp for " + this.getNodeId());
			}
		}
		return commiterTimestamp;
	}

	public Long getTimestamp() {
		if (this.timestamp == null) {
			Long t = this.getGraph().copy().getAuthorTimestamp(this.getNodeId());
			this.timestamp = t == null ? -1 : t;
		}
		return timestamp;
	}

	public String getCommiter() {
		if (this.commiter == null) {
			this.commiter = "" + this.getGraph().copy().getCommitterId(this.getNodeId());
		}
		return commiter;
	}

	/**
	 * Get the parent revision, in case of merge commit, return the first parent
	 * "The first parent is generally considered to be issued from the “main” branch
	 * that the revision is merged onto" Todo: handle in a best way merge commit
	 * 
	 * @return
	 */
	public Revision getParent() {
		// if(parent==null&& !noParent){
		SwhUnidirectionalGraph graphCopy = this.getGraph().copy();
		LazyLongIterator childIt = graphCopy.successors(this.getNodeId());
		Revision parent = null;
		for (long successorNode; (successorNode = childIt.nextLong()) != -1 && parent == null;) {
			switch (graphCopy.getNodeType(successorNode)) {
			case REV: {
				parent = new Revision(successorNode, this.getGraph());
				break;
			}
			}
		}

		return parent;
	}

	public Directory getTree() {
		SwhUnidirectionalGraph graph_copy = this.getGraph().copy();
		LazyLongIterator childIt = graph_copy.successors(this.getNodeId());
		Directory tree = null;
		for (long successorNode; (successorNode = childIt.nextLong()) != -1 && tree == null;) {
			switch (graph_copy.getNodeType(successorNode)) {
			case DIR: {
				tree = new Directory(successorNode, this.getGraph());
				break;
			}
			case CNT: {
				logger.warn("CNT node found");
				break;
			}
			}
		}
		if (tree == null) {
			// then it's not simply the first commit ...
			logger.debug("No tree for revision " + this.getNodeId() + " " + this.getSwhid());
		}
		return tree;
	}

	public String getMessage() {
		if (this.message == null) {
			this.getGraph().copy().getMessage(this.getNodeId());
		}
		return message;
	}

	public String getAuthor() {
		if (this.author == null) {
			this.author = "" + this.getGraph().copy().getAuthorId(this.getNodeId());
		}
		return author;
	}
}
