package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ConnectionPointReference;

@SuppressWarnings("all")
public class ConnectionPointReferenceAspectConnectionPointReferenceAspectContext {
  public static final ConnectionPointReferenceAspectConnectionPointReferenceAspectContext INSTANCE = new ConnectionPointReferenceAspectConnectionPointReferenceAspectContext();
  
  public static ConnectionPointReferenceAspectConnectionPointReferenceAspectProperties getSelf(final ConnectionPointReference _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ConnectionPointReferenceAspectConnectionPointReferenceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ConnectionPointReference, ConnectionPointReferenceAspectConnectionPointReferenceAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ConnectionPointReference, fr.inria.diverse.swhModel.generator.aspects.ConnectionPointReferenceAspectConnectionPointReferenceAspectProperties>();
  
  public Map<ConnectionPointReference, ConnectionPointReferenceAspectConnectionPointReferenceAspectProperties> getMap() {
    return map;
  }
}
