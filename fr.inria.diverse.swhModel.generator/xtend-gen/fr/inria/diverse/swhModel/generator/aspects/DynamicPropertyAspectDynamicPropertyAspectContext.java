package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.DynamicProperty;

@SuppressWarnings("all")
public class DynamicPropertyAspectDynamicPropertyAspectContext {
  public static final DynamicPropertyAspectDynamicPropertyAspectContext INSTANCE = new DynamicPropertyAspectDynamicPropertyAspectContext();
  
  public static DynamicPropertyAspectDynamicPropertyAspectProperties getSelf(final DynamicProperty _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DynamicPropertyAspectDynamicPropertyAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DynamicProperty, DynamicPropertyAspectDynamicPropertyAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.DynamicProperty, fr.inria.diverse.swhModel.generator.aspects.DynamicPropertyAspectDynamicPropertyAspectProperties>();
  
  public Map<DynamicProperty, DynamicPropertyAspectDynamicPropertyAspectProperties> getMap() {
    return map;
  }
}
