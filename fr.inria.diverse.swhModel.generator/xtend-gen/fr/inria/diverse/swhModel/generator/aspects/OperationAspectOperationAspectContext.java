package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Operation;

@SuppressWarnings("all")
public class OperationAspectOperationAspectContext {
  public static final OperationAspectOperationAspectContext INSTANCE = new OperationAspectOperationAspectContext();
  
  public static OperationAspectOperationAspectProperties getSelf(final Operation _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OperationAspectOperationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Operation, OperationAspectOperationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Operation, fr.inria.diverse.swhModel.generator.aspects.OperationAspectOperationAspectProperties>();
  
  public Map<Operation, OperationAspectOperationAspectProperties> getMap() {
    return map;
  }
}
