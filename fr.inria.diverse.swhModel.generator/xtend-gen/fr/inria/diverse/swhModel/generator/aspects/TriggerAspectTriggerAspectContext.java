package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Trigger;

@SuppressWarnings("all")
public class TriggerAspectTriggerAspectContext {
  public static final TriggerAspectTriggerAspectContext INSTANCE = new TriggerAspectTriggerAspectContext();
  
  public static TriggerAspectTriggerAspectProperties getSelf(final Trigger _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TriggerAspectTriggerAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Trigger, TriggerAspectTriggerAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Trigger, fr.inria.diverse.swhModel.generator.aspects.TriggerAspectTriggerAspectProperties>();
  
  public Map<Trigger, TriggerAspectTriggerAspectProperties> getMap() {
    return map;
  }
}
