package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Vertex;

@SuppressWarnings("all")
public class VertexAspectVertexAspectContext {
  public static final VertexAspectVertexAspectContext INSTANCE = new VertexAspectVertexAspectContext();
  
  public static VertexAspectVertexAspectProperties getSelf(final Vertex _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.VertexAspectVertexAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Vertex, VertexAspectVertexAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Vertex, fr.inria.diverse.swhModel.generator.aspects.VertexAspectVertexAspectProperties>();
  
  public Map<Vertex, VertexAspectVertexAspectProperties> getMap() {
    return map;
  }
}
