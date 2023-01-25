package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.IteratorExp;

@SuppressWarnings("all")
public class IteratorExpAspectIteratorExpAspectContext {
  public static final IteratorExpAspectIteratorExpAspectContext INSTANCE = new IteratorExpAspectIteratorExpAspectContext();
  
  public static IteratorExpAspectIteratorExpAspectProperties getSelf(final IteratorExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspectIteratorExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IteratorExp, IteratorExpAspectIteratorExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.IteratorExp, fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspectIteratorExpAspectProperties>();
  
  public Map<IteratorExp, IteratorExpAspectIteratorExpAspectProperties> getMap() {
    return map;
  }
}
