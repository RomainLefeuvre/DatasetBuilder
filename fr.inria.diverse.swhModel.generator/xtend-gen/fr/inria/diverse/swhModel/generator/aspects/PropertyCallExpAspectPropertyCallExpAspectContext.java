package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.PropertyCallExp;

@SuppressWarnings("all")
public class PropertyCallExpAspectPropertyCallExpAspectContext {
  public static final PropertyCallExpAspectPropertyCallExpAspectContext INSTANCE = new PropertyCallExpAspectPropertyCallExpAspectContext();
  
  public static PropertyCallExpAspectPropertyCallExpAspectProperties getSelf(final PropertyCallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspectPropertyCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<PropertyCallExp, PropertyCallExpAspectPropertyCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.PropertyCallExp, fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspectPropertyCallExpAspectProperties>();
  
  public Map<PropertyCallExp, PropertyCallExpAspectPropertyCallExpAspectProperties> getMap() {
    return map;
  }
}
