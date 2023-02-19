package fr.inria.diverse;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import fr.inria.diverse.model.Directory;
import fr.inria.diverse.model.DirectoryEntry;
import fr.inria.diverse.model.Origin;
import fr.inria.diverse.model.Revision;

public class GraphQueryTest {
	static Logger logger = LogManager.getLogger(GraphQueryTest.class);
	private static GraphQueryRunnerTest runner;
	private Graph g;
	static String id = "test";
	private boolean restoreCheckpoint = false;

	@BeforeClass
	public static void init() {
		runner = new GraphQueryRunnerTest();
		runner.init();
		String[] args = { "--queryTimestamp", "2021-03-22", "--exportPath", "./exportTest" };
		runner.execute(args);
		logger.info(runner);

	}

	@AfterClass
	public static void clean() throws IOException {
		FileUtils.deleteDirectory(runner.getExportPath().toFile());

	}

	public GraphQueryTest() throws IOException {
		g = new Graph();
		g.loadGraph();
		g.loadExternalInfo();
	}

	public static Revision getRootRevision(Revision self) {
		while (!(self.getParent() == null)) {
			self = self.getParent();
		}
		return self;
	}

	public Set<Long> runQuery() throws IOException, InterruptedException {
		Set<Long> results = new HashSet<>();
		logger.info("------Executing query " + id + "------");
		List<Long> selectResult = new LambdaExplorer<Long, Long>(g, this.g.getOrigins(), id) {
			@Override
			public Long exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
				Origin origin = new Origin(currentElement, this.graph);
				boolean predicateResult = origin.getLastSnapshot().getBranches().stream()
						.anyMatch(branche -> ((((branche.getName().equals("refs/heads/master")
								|| branche.getName().equals("refs/heads/main"))
								&& RevisionClosure2((new HashSet<Revision>(Arrays.asList(branche.getRevision())))
										.stream().collect(Collectors.toSet())).size() > (1000))
								&& getRootRevision(branche.getRevision()).getCommiterTimestamp() > (1420066800))
								&& DirectoryEntryClosure3(branche.getRevision().getTree().getEntries().stream()
										.collect(Collectors.toSet())).stream()
												.anyMatch(e -> e.getName().equals("README.md"))));
				return predicateResult ? currentElement : null;
			}
		}.explore();
		results.addAll(selectResult);
		return results;
	}

	public static Set<Revision> RevisionClosure2(Set<Revision> param) {
		Stack<Revision> stack = new Stack<>();
		HashSet<Revision> res = new HashSet<>();
		stack.addAll(param);
		res.addAll(param);

		while (!stack.isEmpty()) {
			Set<Revision> children = new HashSet<Revision>();

			Revision var_1 = stack.pop();
			try {
				children = new HashSet<Revision>(Arrays.asList(var_1.getParent()));
			} catch (Exception e) {
				logger.warn("Error during closure for" + param);
				logger.debug("Error during closure for" + param, e);
			}
			for (Revision child : children) {
				if (child != null && !res.contains(child)) {
					res.add(child);
					stack.add(child);
				}
			}

		}
		return res;
	}

	public static Set<DirectoryEntry> DirectoryEntryClosure3(Set<DirectoryEntry> param) {
		Stack<DirectoryEntry> stack = new Stack<>();
		HashSet<DirectoryEntry> res = new HashSet<>();
		stack.addAll(param);
		res.addAll(param);

		while (!stack.isEmpty()) {
			Set<DirectoryEntry> children = new HashSet<DirectoryEntry>();

			DirectoryEntry entry = stack.pop();
			try {
				children = (((entry.getChild() instanceof Directory))
						? (((Directory) entry.getChild()).getEntries().stream().collect(Collectors.toSet()))
						: ((new HashSet<DirectoryEntry>(Arrays.asList(entry)))));
			} catch (Exception e) {
				logger.warn("Error during closure for" + param);
				logger.debug("Error during closure for" + param, e);
			}
			for (DirectoryEntry child : children) {
				if (child != null && !res.contains(child)) {
					res.add(child);
					stack.add(child);
				}
			}

		}
		return res;
	}

	@Test
	public void test() throws IOException, InterruptedException {
		Set<Long> queryResult = this.runQuery();
		assertEquals(28, queryResult.size());
	}
}
