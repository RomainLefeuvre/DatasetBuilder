package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Property;

@SuppressWarnings("all")
public class PropertyAspectPropertyAspectContext {
  public static final PropertyAspectPropertyAspectContext INSTANCE = new PropertyAspectPropertyAspectContext();
  
  public static PropertyAspectPropertyAspectProperties getSelf(final Property _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PropertyAspectPropertyAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Property, PropertyAspectPropertyAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Property, fr.inria.diverse.swhModel.generator.aspects.PropertyAspectPropertyAspectProperties>();
  
  public Map<Property, PropertyAspectPropertyAspectProperties> getMap() {
    return map;
  }
}
