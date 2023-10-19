package fr.inria.diverse.query;

import fr.inria.diverse.*;
import fr.inria.diverse.model.*;
import fr.inria.diverse.requests.ContentClient;
import fr.inria.diverse.requests.VaultClient;
import fr.inria.diverse.tools.*;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;
import java.util.regex.Pattern;

public class GraphQuery implements IGraphQuery {
	static Logger logger = LogManager.getLogger(GraphQuery.class);
	static String id = "RUNNING_QUERY";
	private Graph g;

	private ContentClient contentClient;

	public GraphQuery(Graph g) throws IOException {
		contentClient = new ContentClient();
		this.g = g;
	}

	public Set<Long> runQuery() throws IOException, InterruptedException {
		Set<Long> results = new HashSet<>();
		logger.info("------Executing query " + id + "------");

		// long startTime = System.nanoTime();

		List<Long> selectResult = new LambdaExplorer<Long, Long>(g, this.g.getOrigins(), id) {
			@Override
			public Long exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {

				Pattern fileContentPattern = Pattern
						.compile("(openapi|swagger):\\s*[\"']?[0-9]+\\.[0-9]+[\"']?|paths:|components:");
				Pattern fileNamePattern = Pattern.compile(
						".*api.*\\.(json|yaml|yml)|.*swagger.*\\.(json|yaml|yml)");

				Origin origin = new Origin(currentElement, this.graph);
				boolean predicateResult = origin.getLastSnapshot().getBranches().stream()
						.anyMatch(branche -> ((branche.getName().equals("refs/heads/master") ||
								branche.getName().equals("refs/heads/main"))
								&&
								mapMatchesWithReport(
										DirectoryEntryClosure1(branche.getRevision().getTree().getEntries().stream()
												.collect(Collectors.toSet())),
										fileNamePattern, fileContentPattern, branche)));

				return predicateResult ? currentElement : null;

			}
		}.explore();

		// System.out.println("request time: " + (System.nanoTime() - startTime));

		results.addAll(selectResult);
		return results;
	}

	private boolean mapMatchesWithReport(Stack<Pair<String, DirectoryEntry>> e, Pattern fileName, Pattern fileContent,
			SnapshotBranch currentSnapshotBranch) {
		boolean res = false;
		for (Pair<String, DirectoryEntry> entry : e) {
			if (fileName.matcher(entry.getRight().getName()).matches()) {
				res = contentClient.ReceiveContentRegex(entry.getRight().getChild().getSwhid().split(":")[3],
						fileContent);

				if (res)
					System.out.println(currentSnapshotBranch.getRevision().getSwhid() + " : " + entry.getKey() + " => "
							+ entry.getValue().getName() + ":" + entry.getValue().getChild().getSwhid());
				break;
			}
		}
		return res;
	}

	private static boolean patternMatchesWithReport(DirectoryEntry e, Pattern p, SnapshotBranch currentSnapshotBranch) {
		boolean res = false;
		res = p.matcher(e.getName()).matches();
		if (res) {
			System.out.println(currentSnapshotBranch.getRevision().getSwhid() + " : " + e.getName() + " => "
					+ e.getChild().getSwhid());
		}
		return res;
	}

	public static Stack<Pair<String, DirectoryEntry>> DirectoryEntryClosure1(Set<DirectoryEntry> param) {
		Stack<DirectoryEntry> stack = new Stack<>();
		Stack<String> pathStack = new Stack<>();
		Stack<Pair<String, DirectoryEntry>> res;
		stack.addAll(param);
		pathStack.addAll(param.stream().map(e -> "").collect(Collectors.toList()));
		res = param.stream().map(e -> Pair.of("", e)).collect(Collectors.toCollection(Stack::new));

		while (!stack.isEmpty()) {
			Set<DirectoryEntry> children = new HashSet<DirectoryEntry>();

			DirectoryEntry entry = stack.pop();
			String currentPathString = pathStack.pop();
			try {
				children = (((entry.getChild() instanceof Directory))
						? (((Directory) entry.getChild()).getEntries().stream().collect(Collectors.toSet()))
						: ((new HashSet<DirectoryEntry>(Arrays.asList(entry)))));
			} catch (Exception e) {
				logger.warn("Error during closure for" + param);
				logger.debug("Error during closure for" + param, e);
			}
			for (DirectoryEntry child : children) {
				if (child != null && !res.stream().map(e -> e.getRight()).anyMatch(e -> child.equals(e))) {
					res.add(Pair.of(currentPathString + entry.getName(), child));
					stack.add(child);
					pathStack.add(currentPathString + entry.getName() + "/");
				}
			}

		}
		return res;
	}

}
