package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.StateExp;

@SuppressWarnings("all")
public class StateExpAspectStateExpAspectContext {
  public static final StateExpAspectStateExpAspectContext INSTANCE = new StateExpAspectStateExpAspectContext();
  
  public static StateExpAspectStateExpAspectProperties getSelf(final StateExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.StateExpAspectStateExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StateExp, StateExpAspectStateExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.StateExp, fr.inria.diverse.swhModel.generator.aspects.StateExpAspectStateExpAspectProperties>();
  
  public Map<StateExp, StateExpAspectStateExpAspectProperties> getMap() {
    return map;
  }
}
