package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ShadowPart;

@SuppressWarnings("all")
public class ShadowPartAspectShadowPartAspectContext {
  public static final ShadowPartAspectShadowPartAspectContext INSTANCE = new ShadowPartAspectShadowPartAspectContext();
  
  public static ShadowPartAspectShadowPartAspectProperties getSelf(final ShadowPart _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ShadowPartAspectShadowPartAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ShadowPart, ShadowPartAspectShadowPartAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ShadowPart, fr.inria.diverse.swhModel.generator.aspects.ShadowPartAspectShadowPartAspectProperties>();
  
  public Map<ShadowPart, ShadowPartAspectShadowPartAspectProperties> getMap() {
    return map;
  }
}
