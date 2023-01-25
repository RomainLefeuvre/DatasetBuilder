package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Signal;

@SuppressWarnings("all")
public class SignalAspectSignalAspectContext {
  public static final SignalAspectSignalAspectContext INSTANCE = new SignalAspectSignalAspectContext();
  
  public static SignalAspectSignalAspectProperties getSelf(final Signal _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SignalAspectSignalAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Signal, SignalAspectSignalAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Signal, fr.inria.diverse.swhModel.generator.aspects.SignalAspectSignalAspectProperties>();
  
  public Map<Signal, SignalAspectSignalAspectProperties> getMap() {
    return map;
  }
}
