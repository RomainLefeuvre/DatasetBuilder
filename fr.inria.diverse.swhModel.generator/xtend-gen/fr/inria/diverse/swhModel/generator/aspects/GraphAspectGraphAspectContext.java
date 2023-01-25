package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Graph;
import java.util.Map;

@SuppressWarnings("all")
public class GraphAspectGraphAspectContext {
  public static final GraphAspectGraphAspectContext INSTANCE = new GraphAspectGraphAspectContext();
  
  public static GraphAspectGraphAspectProperties getSelf(final Graph _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.GraphAspectGraphAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Graph, GraphAspectGraphAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Graph, fr.inria.diverse.swhModel.generator.aspects.GraphAspectGraphAspectProperties>();
  
  public Map<Graph, GraphAspectGraphAspectProperties> getMap() {
    return map;
  }
}
