package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.NamedElement;

@SuppressWarnings("all")
public class NamedElementAspectNamedElementAspectContext {
  public static final NamedElementAspectNamedElementAspectContext INSTANCE = new NamedElementAspectNamedElementAspectContext();
  
  public static NamedElementAspectNamedElementAspectProperties getSelf(final NamedElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NamedElementAspectNamedElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NamedElement, NamedElementAspectNamedElementAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.NamedElement, fr.inria.diverse.swhModel.generator.aspects.NamedElementAspectNamedElementAspectProperties>();
  
  public Map<NamedElement, NamedElementAspectNamedElementAspectProperties> getMap() {
    return map;
  }
}
