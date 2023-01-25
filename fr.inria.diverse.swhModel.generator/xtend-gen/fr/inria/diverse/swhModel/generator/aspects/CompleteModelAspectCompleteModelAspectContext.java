package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CompleteModel;

@SuppressWarnings("all")
public class CompleteModelAspectCompleteModelAspectContext {
  public static final CompleteModelAspectCompleteModelAspectContext INSTANCE = new CompleteModelAspectCompleteModelAspectContext();
  
  public static CompleteModelAspectCompleteModelAspectProperties getSelf(final CompleteModel _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CompleteModelAspectCompleteModelAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CompleteModel, CompleteModelAspectCompleteModelAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CompleteModel, fr.inria.diverse.swhModel.generator.aspects.CompleteModelAspectCompleteModelAspectProperties>();
  
  public Map<CompleteModel, CompleteModelAspectCompleteModelAspectProperties> getMap() {
    return map;
  }
}
