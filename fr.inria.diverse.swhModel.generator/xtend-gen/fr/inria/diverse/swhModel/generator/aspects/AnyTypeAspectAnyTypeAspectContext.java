package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.AnyType;

@SuppressWarnings("all")
public class AnyTypeAspectAnyTypeAspectContext {
  public static final AnyTypeAspectAnyTypeAspectContext INSTANCE = new AnyTypeAspectAnyTypeAspectContext();
  
  public static AnyTypeAspectAnyTypeAspectProperties getSelf(final AnyType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.AnyTypeAspectAnyTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<AnyType, AnyTypeAspectAnyTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.AnyType, fr.inria.diverse.swhModel.generator.aspects.AnyTypeAspectAnyTypeAspectProperties>();
  
  public Map<AnyType, AnyTypeAspectAnyTypeAspectProperties> getMap() {
    return map;
  }
}
