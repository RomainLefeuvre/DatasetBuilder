package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Iteration;

@SuppressWarnings("all")
public class IterationAspectIterationAspectContext {
  public static final IterationAspectIterationAspectContext INSTANCE = new IterationAspectIterationAspectContext();
  
  public static IterationAspectIterationAspectProperties getSelf(final Iteration _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IterationAspectIterationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Iteration, IterationAspectIterationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Iteration, fr.inria.diverse.swhModel.generator.aspects.IterationAspectIterationAspectProperties>();
  
  public Map<Iteration, IterationAspectIterationAspectProperties> getMap() {
    return map;
  }
}
