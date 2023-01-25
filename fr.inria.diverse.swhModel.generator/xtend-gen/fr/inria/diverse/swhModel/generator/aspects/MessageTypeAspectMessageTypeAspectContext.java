package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.MessageType;

@SuppressWarnings("all")
public class MessageTypeAspectMessageTypeAspectContext {
  public static final MessageTypeAspectMessageTypeAspectContext INSTANCE = new MessageTypeAspectMessageTypeAspectContext();
  
  public static MessageTypeAspectMessageTypeAspectProperties getSelf(final MessageType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.MessageTypeAspectMessageTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MessageType, MessageTypeAspectMessageTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.MessageType, fr.inria.diverse.swhModel.generator.aspects.MessageTypeAspectMessageTypeAspectProperties>();
  
  public Map<MessageType, MessageTypeAspectMessageTypeAspectProperties> getMap() {
    return map;
  }
}
