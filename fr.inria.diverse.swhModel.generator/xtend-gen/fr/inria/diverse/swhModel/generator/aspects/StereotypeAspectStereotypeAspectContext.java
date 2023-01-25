package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Stereotype;

@SuppressWarnings("all")
public class StereotypeAspectStereotypeAspectContext {
  public static final StereotypeAspectStereotypeAspectContext INSTANCE = new StereotypeAspectStereotypeAspectContext();
  
  public static StereotypeAspectStereotypeAspectProperties getSelf(final Stereotype _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.StereotypeAspectStereotypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Stereotype, StereotypeAspectStereotypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Stereotype, fr.inria.diverse.swhModel.generator.aspects.StereotypeAspectStereotypeAspectProperties>();
  
  public Map<Stereotype, StereotypeAspectStereotypeAspectProperties> getMap() {
    return map;
  }
}
