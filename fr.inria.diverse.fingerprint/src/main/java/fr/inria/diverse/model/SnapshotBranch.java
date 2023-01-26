package fr.inria.diverse.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public class SnapshotBranch implements Serializable {
	private static final long serialVersionUID = 1735830627902451577L;
	static Logger logger = LogManager.getLogger(SnapshotBranch.class);
	private String name;
	private SnapshotChild child;

	public Revision getRevision() {
		if (child instanceof Revision) {
			return (Revision) child;
		} else if (child instanceof Release) {
			return ((Release) child).getRevision();
		} else {
			logger.warn("No Revision for snapshot ");
			return null;
		}
	}

	public SnapshotBranch() {
	}

	public SnapshotBranch(String name, SnapshotChild child) {
		this.name = name;
		this.child = child;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SnapshotChild getChild() {
		return child;
	}

	public void setChild(SnapshotChild child) {
		this.child = child;
	}
}
