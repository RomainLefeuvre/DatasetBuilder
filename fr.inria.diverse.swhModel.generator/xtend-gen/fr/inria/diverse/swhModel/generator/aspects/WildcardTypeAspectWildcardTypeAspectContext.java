package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.WildcardType;

@SuppressWarnings("all")
public class WildcardTypeAspectWildcardTypeAspectContext {
  public static final WildcardTypeAspectWildcardTypeAspectContext INSTANCE = new WildcardTypeAspectWildcardTypeAspectContext();
  
  public static WildcardTypeAspectWildcardTypeAspectProperties getSelf(final WildcardType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.WildcardTypeAspectWildcardTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<WildcardType, WildcardTypeAspectWildcardTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.WildcardType, fr.inria.diverse.swhModel.generator.aspects.WildcardTypeAspectWildcardTypeAspectProperties>();
  
  public Map<WildcardType, WildcardTypeAspectWildcardTypeAspectProperties> getMap() {
    return map;
  }
}
