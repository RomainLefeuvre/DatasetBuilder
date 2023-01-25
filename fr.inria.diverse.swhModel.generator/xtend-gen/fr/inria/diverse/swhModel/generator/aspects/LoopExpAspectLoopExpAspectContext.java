package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.LoopExp;

@SuppressWarnings("all")
public class LoopExpAspectLoopExpAspectContext {
  public static final LoopExpAspectLoopExpAspectContext INSTANCE = new LoopExpAspectLoopExpAspectContext();
  
  public static LoopExpAspectLoopExpAspectProperties getSelf(final LoopExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LoopExpAspectLoopExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LoopExp, LoopExpAspectLoopExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.LoopExp, fr.inria.diverse.swhModel.generator.aspects.LoopExpAspectLoopExpAspectProperties>();
  
  public Map<LoopExp, LoopExpAspectLoopExpAspectProperties> getMap() {
    return map;
  }
}
