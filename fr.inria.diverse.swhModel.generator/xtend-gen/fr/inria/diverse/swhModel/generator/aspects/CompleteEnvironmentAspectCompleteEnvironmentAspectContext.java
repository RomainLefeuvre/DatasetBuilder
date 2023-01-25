package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CompleteEnvironment;

@SuppressWarnings("all")
public class CompleteEnvironmentAspectCompleteEnvironmentAspectContext {
  public static final CompleteEnvironmentAspectCompleteEnvironmentAspectContext INSTANCE = new CompleteEnvironmentAspectCompleteEnvironmentAspectContext();
  
  public static CompleteEnvironmentAspectCompleteEnvironmentAspectProperties getSelf(final CompleteEnvironment _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CompleteEnvironmentAspectCompleteEnvironmentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CompleteEnvironment, CompleteEnvironmentAspectCompleteEnvironmentAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CompleteEnvironment, fr.inria.diverse.swhModel.generator.aspects.CompleteEnvironmentAspectCompleteEnvironmentAspectProperties>();
  
  public Map<CompleteEnvironment, CompleteEnvironmentAspectCompleteEnvironmentAspectProperties> getMap() {
    return map;
  }
}
