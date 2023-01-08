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

public class GraphQuery {
    static Logger logger = LogManager.getLogger(GraphQuery.class);
    private Graph g;

    public GraphQuery() throws IOException {
        g = new Graph();
        g.loadGraph();
    }
    
public Set<Long> runQuery() throws IOException, InterruptedException {
	Set<Long> results = new HashSet<>();
	List<Long> selectResult = new LambdaExplorer<Long, Long>(g, this.g.getOrigins()) {
	    @Override
		public void exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
		    Origin origin = new Origin(currentElement, graphCopy);
		    boolean predicateResult = (origin.getOriginVisits().stream().allMatch(originVisit ->
		    	originVisit.getSnapshot().getBranches().stream().allMatch(branche ->
		    		RevisionClosure2((new HashSet<Revision>(Arrays.asList(branche.getRevision()))).stream().collect(Collectors.toSet()))
		    		.stream().allMatch(closur ->
		    			closur.getTimestamp() > (1420066800)
		    		)
		    	)
		    ) && 
		    	origin.getOriginVisits().stream().anyMatch(originVisit ->
		    		originVisit.getSnapshot().getBranches().stream().anyMatch(branche ->
		    			((branche.getName().equals("refs/heads/master") || 
		    				branche.getName().equals("refs/heads/main"))
		    			 && 
		    				RevisionClosure4((new HashSet<Revision>(Arrays.asList(branche.getRevision()))).stream().collect(Collectors.toSet()))
		    				.size() > (1000))
		    		)
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

 public static Set<Revision> RevisionClosure4(Set<Revision> param ){
 		Stack<Revision> stack = new Stack<>();
 		HashSet<Revision> res = new HashSet<>();
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

    public static void main(String[] args) throws IOException, InterruptedException {
        Configuration.init();
        Set<Long> queryResult = new GraphQuery().runQuery();
        ToolBox.exportObjectToJson(queryResult, Configuration.getInstance().getExportPath() + "/query/results");
    }	
}
