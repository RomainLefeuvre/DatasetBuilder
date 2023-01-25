package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CompleteClass;

@SuppressWarnings("all")
public class CompleteClassAspectCompleteClassAspectContext {
  public static final CompleteClassAspectCompleteClassAspectContext INSTANCE = new CompleteClassAspectCompleteClassAspectContext();
  
  public static CompleteClassAspectCompleteClassAspectProperties getSelf(final CompleteClass _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CompleteClassAspectCompleteClassAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CompleteClass, CompleteClassAspectCompleteClassAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CompleteClass, fr.inria.diverse.swhModel.generator.aspects.CompleteClassAspectCompleteClassAspectProperties>();
  
  public Map<CompleteClass, CompleteClassAspectCompleteClassAspectProperties> getMap() {
    return map;
  }
}
