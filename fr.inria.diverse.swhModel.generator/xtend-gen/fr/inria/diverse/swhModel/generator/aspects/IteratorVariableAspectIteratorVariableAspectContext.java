package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.IteratorVariable;

@SuppressWarnings("all")
public class IteratorVariableAspectIteratorVariableAspectContext {
  public static final IteratorVariableAspectIteratorVariableAspectContext INSTANCE = new IteratorVariableAspectIteratorVariableAspectContext();
  
  public static IteratorVariableAspectIteratorVariableAspectProperties getSelf(final IteratorVariable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IteratorVariableAspectIteratorVariableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IteratorVariable, IteratorVariableAspectIteratorVariableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.IteratorVariable, fr.inria.diverse.swhModel.generator.aspects.IteratorVariableAspectIteratorVariableAspectProperties>();
  
  public Map<IteratorVariable, IteratorVariableAspectIteratorVariableAspectProperties> getMap() {
    return map;
  }
}
