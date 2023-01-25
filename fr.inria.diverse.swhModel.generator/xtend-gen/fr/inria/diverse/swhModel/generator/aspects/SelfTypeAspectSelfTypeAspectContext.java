package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.SelfType;

@SuppressWarnings("all")
public class SelfTypeAspectSelfTypeAspectContext {
  public static final SelfTypeAspectSelfTypeAspectContext INSTANCE = new SelfTypeAspectSelfTypeAspectContext();
  
  public static SelfTypeAspectSelfTypeAspectProperties getSelf(final SelfType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SelfTypeAspectSelfTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SelfType, SelfTypeAspectSelfTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.SelfType, fr.inria.diverse.swhModel.generator.aspects.SelfTypeAspectSelfTypeAspectProperties>();
  
  public Map<SelfType, SelfTypeAspectSelfTypeAspectProperties> getMap() {
    return map;
  }
}
