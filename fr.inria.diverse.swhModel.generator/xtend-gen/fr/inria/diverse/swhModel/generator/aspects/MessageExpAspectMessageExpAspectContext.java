package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.MessageExp;

@SuppressWarnings("all")
public class MessageExpAspectMessageExpAspectContext {
  public static final MessageExpAspectMessageExpAspectContext INSTANCE = new MessageExpAspectMessageExpAspectContext();
  
  public static MessageExpAspectMessageExpAspectProperties getSelf(final MessageExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.MessageExpAspectMessageExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MessageExp, MessageExpAspectMessageExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.MessageExp, fr.inria.diverse.swhModel.generator.aspects.MessageExpAspectMessageExpAspectProperties>();
  
  public Map<MessageExp, MessageExpAspectMessageExpAspectProperties> getMap() {
    return map;
  }
}
