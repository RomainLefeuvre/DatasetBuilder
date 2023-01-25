package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ParameterVariable;

@SuppressWarnings("all")
public class ParameterVariableAspectParameterVariableAspectContext {
  public static final ParameterVariableAspectParameterVariableAspectContext INSTANCE = new ParameterVariableAspectParameterVariableAspectContext();
  
  public static ParameterVariableAspectParameterVariableAspectProperties getSelf(final ParameterVariable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ParameterVariableAspectParameterVariableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ParameterVariable, ParameterVariableAspectParameterVariableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ParameterVariable, fr.inria.diverse.swhModel.generator.aspects.ParameterVariableAspectParameterVariableAspectProperties>();
  
  public Map<ParameterVariable, ParameterVariableAspectParameterVariableAspectProperties> getMap() {
    return map;
  }
}
