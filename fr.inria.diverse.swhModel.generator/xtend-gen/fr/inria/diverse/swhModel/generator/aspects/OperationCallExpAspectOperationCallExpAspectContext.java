package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.OperationCallExp;

@SuppressWarnings("all")
public class OperationCallExpAspectOperationCallExpAspectContext {
  public static final OperationCallExpAspectOperationCallExpAspectContext INSTANCE = new OperationCallExpAspectOperationCallExpAspectContext();
  
  public static OperationCallExpAspectOperationCallExpAspectProperties getSelf(final OperationCallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspectOperationCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OperationCallExp, OperationCallExpAspectOperationCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.OperationCallExp, fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspectOperationCallExpAspectProperties>();
  
  public Map<OperationCallExp, OperationCallExpAspectOperationCallExpAspectProperties> getMap() {
    return map;
  }
}
