package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ResultVariable;

@SuppressWarnings("all")
public class ResultVariableAspectResultVariableAspectContext {
  public static final ResultVariableAspectResultVariableAspectContext INSTANCE = new ResultVariableAspectResultVariableAspectContext();
  
  public static ResultVariableAspectResultVariableAspectProperties getSelf(final ResultVariable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ResultVariableAspectResultVariableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ResultVariable, ResultVariableAspectResultVariableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ResultVariable, fr.inria.diverse.swhModel.generator.aspects.ResultVariableAspectResultVariableAspectProperties>();
  
  public Map<ResultVariable, ResultVariableAspectResultVariableAspectProperties> getMap() {
    return map;
  }
}
