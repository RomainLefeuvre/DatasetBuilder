package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Transition;

@SuppressWarnings("all")
public class TransitionAspectTransitionAspectContext {
  public static final TransitionAspectTransitionAspectContext INSTANCE = new TransitionAspectTransitionAspectContext();
  
  public static TransitionAspectTransitionAspectProperties getSelf(final Transition _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TransitionAspectTransitionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Transition, TransitionAspectTransitionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Transition, fr.inria.diverse.swhModel.generator.aspects.TransitionAspectTransitionAspectProperties>();
  
  public Map<Transition, TransitionAspectTransitionAspectProperties> getMap() {
    return map;
  }
}
