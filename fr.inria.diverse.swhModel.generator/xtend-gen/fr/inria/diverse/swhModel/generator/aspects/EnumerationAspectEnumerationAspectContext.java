package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Enumeration;

@SuppressWarnings("all")
public class EnumerationAspectEnumerationAspectContext {
  public static final EnumerationAspectEnumerationAspectContext INSTANCE = new EnumerationAspectEnumerationAspectContext();
  
  public static EnumerationAspectEnumerationAspectProperties getSelf(final Enumeration _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.EnumerationAspectEnumerationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Enumeration, EnumerationAspectEnumerationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Enumeration, fr.inria.diverse.swhModel.generator.aspects.EnumerationAspectEnumerationAspectProperties>();
  
  public Map<Enumeration, EnumerationAspectEnumerationAspectProperties> getMap() {
    return map;
  }
}
