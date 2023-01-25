package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Element;

@SuppressWarnings("all")
public class ElementAspectElementAspectContext {
  public static final ElementAspectElementAspectContext INSTANCE = new ElementAspectElementAspectContext();
  
  public static ElementAspectElementAspectProperties getSelf(final Element _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ElementAspectElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Element, ElementAspectElementAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Element, fr.inria.diverse.swhModel.generator.aspects.ElementAspectElementAspectProperties>();
  
  public Map<Element, ElementAspectElementAspectProperties> getMap() {
    return map;
  }
}
