package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ElementExtension;

@SuppressWarnings("all")
public class ElementExtensionAspectElementExtensionAspectContext {
  public static final ElementExtensionAspectElementExtensionAspectContext INSTANCE = new ElementExtensionAspectElementExtensionAspectContext();
  
  public static ElementExtensionAspectElementExtensionAspectProperties getSelf(final ElementExtension _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ElementExtensionAspectElementExtensionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ElementExtension, ElementExtensionAspectElementExtensionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ElementExtension, fr.inria.diverse.swhModel.generator.aspects.ElementExtensionAspectElementExtensionAspectProperties>();
  
  public Map<ElementExtension, ElementExtensionAspectElementExtensionAspectProperties> getMap() {
    return map;
  }
}
