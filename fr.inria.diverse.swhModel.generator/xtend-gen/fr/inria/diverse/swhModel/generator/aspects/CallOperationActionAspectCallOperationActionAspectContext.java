package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CallOperationAction;

@SuppressWarnings("all")
public class CallOperationActionAspectCallOperationActionAspectContext {
  public static final CallOperationActionAspectCallOperationActionAspectContext INSTANCE = new CallOperationActionAspectCallOperationActionAspectContext();
  
  public static CallOperationActionAspectCallOperationActionAspectProperties getSelf(final CallOperationAction _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CallOperationActionAspectCallOperationActionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CallOperationAction, CallOperationActionAspectCallOperationActionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CallOperationAction, fr.inria.diverse.swhModel.generator.aspects.CallOperationActionAspectCallOperationActionAspectProperties>();
  
  public Map<CallOperationAction, CallOperationActionAspectCallOperationActionAspectProperties> getMap() {
    return map;
  }
}
