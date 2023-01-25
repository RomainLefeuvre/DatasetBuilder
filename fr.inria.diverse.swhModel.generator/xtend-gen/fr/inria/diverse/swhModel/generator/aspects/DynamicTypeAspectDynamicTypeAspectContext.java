package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.DynamicType;

@SuppressWarnings("all")
public class DynamicTypeAspectDynamicTypeAspectContext {
  public static final DynamicTypeAspectDynamicTypeAspectContext INSTANCE = new DynamicTypeAspectDynamicTypeAspectContext();
  
  public static DynamicTypeAspectDynamicTypeAspectProperties getSelf(final DynamicType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DynamicTypeAspectDynamicTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DynamicType, DynamicTypeAspectDynamicTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.DynamicType, fr.inria.diverse.swhModel.generator.aspects.DynamicTypeAspectDynamicTypeAspectProperties>();
  
  public Map<DynamicType, DynamicTypeAspectDynamicTypeAspectProperties> getMap() {
    return map;
  }
}
