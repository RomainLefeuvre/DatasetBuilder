package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.SendSignalAction;

@SuppressWarnings("all")
public class SendSignalActionAspectSendSignalActionAspectContext {
  public static final SendSignalActionAspectSendSignalActionAspectContext INSTANCE = new SendSignalActionAspectSendSignalActionAspectContext();
  
  public static SendSignalActionAspectSendSignalActionAspectProperties getSelf(final SendSignalAction _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SendSignalActionAspectSendSignalActionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SendSignalAction, SendSignalActionAspectSendSignalActionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.SendSignalAction, fr.inria.diverse.swhModel.generator.aspects.SendSignalActionAspectSendSignalActionAspectProperties>();
  
  public Map<SendSignalAction, SendSignalActionAspectSendSignalActionAspectProperties> getMap() {
    return map;
  }
}
