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
		    boolean predicateResult = origin.getOriginVisits().stream().anyMatch(originVisit ->
		    	originVisit.getSnapshot().getBranches().stream().anyMatch(branche ->
		    		((branche.getName().equals("refs/heads/master") || 
		    			branche.getName().equals("refs/heads/main"))
		    		 && 
		    			getParentRevisionClosure((new HashSet<Revision>(Arrays.asList(branche.getRevision()))))
		    			.size() > (100))
		    	)
		    );
		    if (predicateResult) {
		    	result.add(currentElement);
		    }
		}
	}.explore();
	results.addAll(selectResult);
	return results;			    
}

 public static Set<Revision> getParentRevisionClosure(Set<Revision> param ){
 		Stack<Revision> stack = new Stack<>();
 		HashSet<Revision> res = new HashSet<>();
 		stack.addAll(param);
 		res.addAll(param);
 		
 		while(!stack.isEmpty()){
 		            Revision current=stack.pop();
 		            Set<Revision> children= new HashSet<Revision>(Arrays.asList(current.getParent()));
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