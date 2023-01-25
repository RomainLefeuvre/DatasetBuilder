package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CallExp;

@SuppressWarnings("all")
public class CallExpAspectCallExpAspectContext {
  public static final CallExpAspectCallExpAspectContext INSTANCE = new CallExpAspectCallExpAspectContext();
  
  public static CallExpAspectCallExpAspectProperties getSelf(final CallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CallExpAspectCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CallExp, CallExpAspectCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CallExp, fr.inria.diverse.swhModel.generator.aspects.CallExpAspectCallExpAspectProperties>();
  
  public Map<CallExp, CallExpAspectCallExpAspectProperties> getMap() {
    return map;
  }
}
