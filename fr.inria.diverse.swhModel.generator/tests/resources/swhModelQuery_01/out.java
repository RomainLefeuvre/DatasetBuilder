package fr.inria.diverse.query;
import fr.inria.diverse.*;
import fr.inria.diverse.model.*;
import fr.inria.diverse.tools.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.softwareheritage.graph.SwhType;
import org.softwareheritage.graph.SwhUnidirectionalGraph;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;

public class GraphQuery implements IGraphQuery{
    static Logger logger = LogManager.getLogger(GraphQuery.class);
    static String id = "query";
    private Graph g;		    

    public GraphQuery() throws IOException {
        g = new Graph();
        g.init();
    }
		
	public static Revision getRootRevision( Revision self){
		return 	((self.getParent().equals(null))?
			(self):
			(getRootRevision(self.getParent()))
		)		
		;
		
	} 
	public Set<Long> runQuery() throws IOException, InterruptedException {
		Set<Long> results = new HashSet<>();
		logger.info("------Executing query "+id+"------");
		List<Long> selectResult = new LambdaExplorer<Long, Long>(g, this.g.getOrigins(),id) {
		    @Override
			public void exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
			    Origin origin = new Origin(currentElement, this.graph);
			    boolean predicateResult = origin.getLastSnapshot().getBranches().stream().anyMatch(branche ->
			    	((((branche.getName().equals("refs/heads/master") || 
			    		branche.getName().equals("refs/heads/main"))
			    	 && 
			    		RevisionClosure2((new HashSet<Revision>(Arrays.asList(branche.getRevision()))).stream().collect(Collectors.toSet()))
			    		.size() > (1000))
			    	 && 
			    		getRootRevision(branche.getRevision()).getCommiterTimestamp() > (1420066800))
			    	 && 
			    		DirectoryEntryClosure3(branche.getRevision().getTree().getEntries().stream().collect(Collectors.toSet()))
			    		.stream().anyMatch(e ->
			    			e.getName().equals("AndroidManifest.xml")
			    		))
			    );
			    if (predicateResult) {
			    	result.add(currentElement);
			    }
			}
		}.explore();
		results.addAll(selectResult);
		return results;			    
	}
	
	 public static Set<Revision> RevisionClosure2(Set<Revision> param ){
	 		Stack<Revision> stack = new Stack<>();
	 		HashSet<Revision> res = new HashSet<>();
	 		stack.addAll(param);
	 		res.addAll(param);
	 		
	 		while(!stack.isEmpty()){
	 			        Set<Revision> children= new HashSet<Revision>();
	 					
	 		            Revision var_1=stack.pop();
	 		            try{
	 		            children= new HashSet<Revision>(Arrays.asList(var_1.getParent()));
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
	
	 public static Set<DirectoryEntry> DirectoryEntryClosure3(Set<DirectoryEntry> param ){
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
}
