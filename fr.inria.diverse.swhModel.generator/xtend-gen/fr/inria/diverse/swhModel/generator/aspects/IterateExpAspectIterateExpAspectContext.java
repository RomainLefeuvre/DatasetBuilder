package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.IterateExp;

@SuppressWarnings("all")
public class IterateExpAspectIterateExpAspectContext {
  public static final IterateExpAspectIterateExpAspectContext INSTANCE = new IterateExpAspectIterateExpAspectContext();
  
  public static IterateExpAspectIterateExpAspectProperties getSelf(final IterateExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IterateExpAspectIterateExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IterateExp, IterateExpAspectIterateExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.IterateExp, fr.inria.diverse.swhModel.generator.aspects.IterateExpAspectIterateExpAspectProperties>();
  
  public Map<IterateExp, IterateExpAspectIterateExpAspectProperties> getMap() {
    return map;
  }
}
