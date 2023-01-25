package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Parameter;

@SuppressWarnings("all")
public class ParameterAspectParameterAspectContext {
  public static final ParameterAspectParameterAspectContext INSTANCE = new ParameterAspectParameterAspectContext();
  
  public static ParameterAspectParameterAspectProperties getSelf(final Parameter _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ParameterAspectParameterAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Parameter, ParameterAspectParameterAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Parameter, fr.inria.diverse.swhModel.generator.aspects.ParameterAspectParameterAspectProperties>();
  
  public Map<Parameter, ParameterAspectParameterAspectProperties> getMap() {
    return map;
  }
}
