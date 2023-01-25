package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.utilities.Nameable;

@SuppressWarnings("all")
public class NameableAspectNameableAspectContext {
  public static final NameableAspectNameableAspectContext INSTANCE = new NameableAspectNameableAspectContext();
  
  public static NameableAspectNameableAspectProperties getSelf(final Nameable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NameableAspectNameableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Nameable, NameableAspectNameableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.utilities.Nameable, fr.inria.diverse.swhModel.generator.aspects.NameableAspectNameableAspectProperties>();
  
  public Map<Nameable, NameableAspectNameableAspectProperties> getMap() {
    return map;
  }
}
