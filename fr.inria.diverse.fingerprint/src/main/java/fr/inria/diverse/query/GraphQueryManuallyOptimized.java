package fr.inria.diverse.query;

import fr.inria.diverse.Graph;
import fr.inria.diverse.LambdaExplorer;
import fr.inria.diverse.model.Origin;
import fr.inria.diverse.tools.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import fr.inria.diverse.tools.ToolBox;
import java.io.IOException;
import fr.inria.diverse.model.*;
import java.util.stream.Collectors;
import java.util.*;

public class GraphQueryManuallyOptimized {
    static Logger logger = LogManager.getLogger(GraphQuery.class);
    private Graph g;

    public GraphQueryManuallyOptimized() throws IOException {
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
                        origin.getOriginVisits().stream().anyMatch(o->o.getSnapshot().getBranches().stream().anyMatch(branche ->
                                ((branche.getName().equals("refs/heads/master") ||
                                        branche.getName().equals("refs/heads/main"))
                                        &&
                                        pred1_3(branche)
                                        &&
                                        DirectoryEntryClosure5(branche.getRevision().getTree().getEntries().stream().collect(Collectors.toSet()))
                                                .stream().anyMatch(e ->
                                                        e.getName().equals("README.md")
                                                ))
                        ))

                        ;
                if (predicateResult) {
                    result.add(currentElement);
                }
            }
        }.explore();
        results.addAll(selectResult);
        return results;
    }
    public static boolean pred1_3(SnapshotBranch b){
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
    public static List<Revision> RevisionClosure4(List<Revision> param ){
        Stack<Revision> stack = new Stack<>();
        ArrayList<Revision> res = new ArrayList<>();
        stack.addAll(param);
        res.addAll(param);

        while(!stack.isEmpty()){
            Set<Revision> children= new HashSet<Revision>();

            Revision var_3=stack.pop();
            try{
                children= new HashSet<Revision>(Arrays.asList(var_3.getParent()));
            }catch(Exception e){
                logger.warn("Error during closure for"+ param);
                logger.debug("Error during closure for"+ param,e);
            }
            for(Revision child: children){
                if(child!=null && !res.contains(child)){
                    res.add(child);
                    stack.add(child);
                }
            }

        }
        return res;
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

    public static void main(String[] args) throws IOException, InterruptedException {
        Configuration.init();
        Set<Long> queryResult = new GraphQueryManuallyOptimized().runQuery();
    }
}
