package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.DynamicElement;

@SuppressWarnings("all")
public class DynamicElementAspectDynamicElementAspectContext {
  public static final DynamicElementAspectDynamicElementAspectContext INSTANCE = new DynamicElementAspectDynamicElementAspectContext();
  
  public static DynamicElementAspectDynamicElementAspectProperties getSelf(final DynamicElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DynamicElementAspectDynamicElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DynamicElement, DynamicElementAspectDynamicElementAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.DynamicElement, fr.inria.diverse.swhModel.generator.aspects.DynamicElementAspectDynamicElementAspectProperties>();
  
  public Map<DynamicElement, DynamicElementAspectDynamicElementAspectProperties> getMap() {
    return map;
  }
}
