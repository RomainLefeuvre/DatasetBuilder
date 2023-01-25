package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.LetVariable;

@SuppressWarnings("all")
public class LetVariableAspectLetVariableAspectContext {
  public static final LetVariableAspectLetVariableAspectContext INSTANCE = new LetVariableAspectLetVariableAspectContext();
  
  public static LetVariableAspectLetVariableAspectProperties getSelf(final LetVariable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LetVariableAspectLetVariableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LetVariable, LetVariableAspectLetVariableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.LetVariable, fr.inria.diverse.swhModel.generator.aspects.LetVariableAspectLetVariableAspectProperties>();
  
  public Map<LetVariable, LetVariableAspectLetVariableAspectProperties> getMap() {
    return map;
  }
}
