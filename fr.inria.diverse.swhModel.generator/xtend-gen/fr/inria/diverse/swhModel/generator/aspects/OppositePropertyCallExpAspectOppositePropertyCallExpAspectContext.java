package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;

@SuppressWarnings("all")
public class OppositePropertyCallExpAspectOppositePropertyCallExpAspectContext {
  public static final OppositePropertyCallExpAspectOppositePropertyCallExpAspectContext INSTANCE = new OppositePropertyCallExpAspectOppositePropertyCallExpAspectContext();
  
  public static OppositePropertyCallExpAspectOppositePropertyCallExpAspectProperties getSelf(final OppositePropertyCallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OppositePropertyCallExpAspectOppositePropertyCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OppositePropertyCallExp, OppositePropertyCallExpAspectOppositePropertyCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.OppositePropertyCallExp, fr.inria.diverse.swhModel.generator.aspects.OppositePropertyCallExpAspectOppositePropertyCallExpAspectProperties>();
  
  public Map<OppositePropertyCallExp, OppositePropertyCallExpAspectOppositePropertyCallExpAspectProperties> getMap() {
    return map;
  }
}
