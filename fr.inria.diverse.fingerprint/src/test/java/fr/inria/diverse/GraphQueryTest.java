package fr.inria.diverse;

import fr.inria.diverse.Graph;
import fr.inria.diverse.LambdaExplorer;
import fr.inria.diverse.model.Origin;
import fr.inria.diverse.query.GraphQueryRunner;
import fr.inria.diverse.tools.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.softwareheritage.graph.SWHID;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import fr.inria.diverse.tools.ToolBox;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import fr.inria.diverse.model.*;
import java.util.stream.Collectors;
import java.util.*;

public class GraphQueryTest {
    static Logger logger = LogManager.getLogger(GraphQueryTest.class);
    private Graph g;
    private boolean restoreCheckpoint = false;
    @BeforeClass
    public static void init() {
    	GraphQueryRunnerTest runner =new GraphQueryRunnerTest();
    	runner.init();
    	runner.execute(new String[0]);
		
    }
    public GraphQueryTest() throws IOException {
        g = new Graph();
        g.loadGraph();
    }
    

    public Set<Long> runQuery() throws IOException, InterruptedException {
        Set<Long> results = new HashSet<>();
        String id = "05b860db-1362-45af-989f-e53847c9b1db";
        logger.info("------Executing query "+id+"------");
        List<Long> selectResult = new LambdaExplorer<Long, Long>(g, this.g.getOrigins(),id) {
            @Override
            public void exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
                Origin origin = new Origin(currentElement, graphCopy);
                boolean predicateResult =
                        origin.getLastVisit().getSnapshot().getBranches().stream().anyMatch(branche ->
                                ((branche.getName().equals("refs/heads/master") ||
                                        branche.getName().equals("refs/heads/main"))
                                        &&
                                        optimizationPredicate1_3(branche)
                                        &&
                                        DirectoryEntryClosure5(branche.getRevision().getTree().getEntries().stream().collect(Collectors.toSet()))
                                                .stream().anyMatch(e ->
                                                        e.getName().equals("README.md")
                                                ))
                        )

                        ;
                if (predicateResult) {
                    result.add(currentElement);
                }
            }
        }.explore(restoreCheckpoint);
        results.addAll(selectResult);
        return results;
    }
    public static boolean optimizationPredicate1_3(SnapshotBranch b){
        Revision current = b.getRevision();
        Revision parent = current!=null?current.getParent():null;
        int count =1;
        while(parent!=null){
            current=parent;
            parent=parent.getParent();
            count++;
        }
        return (current.getCommiterTimestamp() > 1420066800)&& (count>1000);
    }


    public static Set<DirectoryEntry> DirectoryEntryClosure5(Set<DirectoryEntry> param ){
        Stack<DirectoryEntry> stack = new Stack<>();
        HashSet<DirectoryEntry> res = new HashSet<>();
        stack.addAll(param);
        res.addAll(param);

        while(!stack.isEmpty()){
            Set<DirectoryEntry> children= new HashSet<DirectoryEntry>();

            DirectoryEntry entry=stack.pop();
            try{
                children= (((entry.getChild() instanceof Directory))?
                        (((Directory) entry.getChild()).getEntries().stream().collect(Collectors.toSet())
                        ):
                        ((new HashSet<DirectoryEntry>(Arrays.asList(entry))))
                )
                ;
            }catch(Exception e){
                logger.warn("Error during closure for"+ param);
                logger.debug("Error during closure for"+ param,e);
            }
            for(DirectoryEntry child: children){
                if(child!=null && !res.contains(child)){
                    res.add(child);
                    stack.add(child);
                }
            }

        }
        return res;
    }
	@Test
    public void test() throws IOException, InterruptedException {
        Set<Long> queryResult = new GraphQueryTest().runQuery();
        assertEquals(28,queryResult.size());
    }
}
