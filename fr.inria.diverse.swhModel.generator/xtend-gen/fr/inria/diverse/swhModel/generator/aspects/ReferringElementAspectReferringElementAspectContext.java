package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ReferringElement;

@SuppressWarnings("all")
public class ReferringElementAspectReferringElementAspectContext {
  public static final ReferringElementAspectReferringElementAspectContext INSTANCE = new ReferringElementAspectReferringElementAspectContext();
  
  public static ReferringElementAspectReferringElementAspectProperties getSelf(final ReferringElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ReferringElementAspectReferringElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ReferringElement, ReferringElementAspectReferringElementAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ReferringElement, fr.inria.diverse.swhModel.generator.aspects.ReferringElementAspectReferringElementAspectProperties>();
  
  public Map<ReferringElement, ReferringElementAspectReferringElementAspectProperties> getMap() {
    return map;
  }
}
