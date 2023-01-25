package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.DynamicBehavior;

@SuppressWarnings("all")
public class DynamicBehaviorAspectDynamicBehaviorAspectContext {
  public static final DynamicBehaviorAspectDynamicBehaviorAspectContext INSTANCE = new DynamicBehaviorAspectDynamicBehaviorAspectContext();
  
  public static DynamicBehaviorAspectDynamicBehaviorAspectProperties getSelf(final DynamicBehavior _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DynamicBehaviorAspectDynamicBehaviorAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DynamicBehavior, DynamicBehaviorAspectDynamicBehaviorAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.DynamicBehavior, fr.inria.diverse.swhModel.generator.aspects.DynamicBehaviorAspectDynamicBehaviorAspectProperties>();
  
  public Map<DynamicBehavior, DynamicBehaviorAspectDynamicBehaviorAspectProperties> getMap() {
    return map;
  }
}
