package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Namespace;

@SuppressWarnings("all")
public class NamespaceAspectNamespaceAspectContext {
  public static final NamespaceAspectNamespaceAspectContext INSTANCE = new NamespaceAspectNamespaceAspectContext();
  
  public static NamespaceAspectNamespaceAspectProperties getSelf(final Namespace _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NamespaceAspectNamespaceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Namespace, NamespaceAspectNamespaceAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Namespace, fr.inria.diverse.swhModel.generator.aspects.NamespaceAspectNamespaceAspectProperties>();
  
  public Map<Namespace, NamespaceAspectNamespaceAspectProperties> getMap() {
    return map;
  }
}
