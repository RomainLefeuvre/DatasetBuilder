package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.InvalidType;

@SuppressWarnings("all")
public class InvalidTypeAspectInvalidTypeAspectContext {
  public static final InvalidTypeAspectInvalidTypeAspectContext INSTANCE = new InvalidTypeAspectInvalidTypeAspectContext();
  
  public static InvalidTypeAspectInvalidTypeAspectProperties getSelf(final InvalidType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.InvalidTypeAspectInvalidTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InvalidType, InvalidTypeAspectInvalidTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.InvalidType, fr.inria.diverse.swhModel.generator.aspects.InvalidTypeAspectInvalidTypeAspectProperties>();
  
  public Map<InvalidType, InvalidTypeAspectInvalidTypeAspectProperties> getMap() {
    return map;
  }
}
