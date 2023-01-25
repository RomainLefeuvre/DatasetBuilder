package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.IterableType;

@SuppressWarnings("all")
public class IterableTypeAspectIterableTypeAspectContext {
  public static final IterableTypeAspectIterableTypeAspectContext INSTANCE = new IterableTypeAspectIterableTypeAspectContext();
  
  public static IterableTypeAspectIterableTypeAspectProperties getSelf(final IterableType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IterableTypeAspectIterableTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IterableType, IterableTypeAspectIterableTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.IterableType, fr.inria.diverse.swhModel.generator.aspects.IterableTypeAspectIterableTypeAspectProperties>();
  
  public Map<IterableType, IterableTypeAspectIterableTypeAspectProperties> getMap() {
    return map;
  }
}
