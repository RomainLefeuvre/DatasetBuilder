package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Variable;

@SuppressWarnings("all")
public class VariableAspectVariableAspectContext {
  public static final VariableAspectVariableAspectContext INSTANCE = new VariableAspectVariableAspectContext();
  
  public static VariableAspectVariableAspectProperties getSelf(final Variable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.VariableAspectVariableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Variable, VariableAspectVariableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Variable, fr.inria.diverse.swhModel.generator.aspects.VariableAspectVariableAspectProperties>();
  
  public Map<Variable, VariableAspectVariableAspectProperties> getMap() {
    return map;
  }
}
