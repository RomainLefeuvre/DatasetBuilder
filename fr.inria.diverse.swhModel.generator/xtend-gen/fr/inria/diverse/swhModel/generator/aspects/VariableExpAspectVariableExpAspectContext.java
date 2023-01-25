package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.VariableExp;

@SuppressWarnings("all")
public class VariableExpAspectVariableExpAspectContext {
  public static final VariableExpAspectVariableExpAspectContext INSTANCE = new VariableExpAspectVariableExpAspectContext();
  
  public static VariableExpAspectVariableExpAspectProperties getSelf(final VariableExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.VariableExpAspectVariableExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<VariableExp, VariableExpAspectVariableExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.VariableExp, fr.inria.diverse.swhModel.generator.aspects.VariableExpAspectVariableExpAspectProperties>();
  
  public Map<VariableExp, VariableExpAspectVariableExpAspectProperties> getMap() {
    return map;
  }
}
