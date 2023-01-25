package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ShadowExp;

@SuppressWarnings("all")
public class ShadowExpAspectShadowExpAspectContext {
  public static final ShadowExpAspectShadowExpAspectContext INSTANCE = new ShadowExpAspectShadowExpAspectContext();
  
  public static ShadowExpAspectShadowExpAspectProperties getSelf(final ShadowExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ShadowExpAspectShadowExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ShadowExp, ShadowExpAspectShadowExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ShadowExp, fr.inria.diverse.swhModel.generator.aspects.ShadowExpAspectShadowExpAspectProperties>();
  
  public Map<ShadowExp, ShadowExpAspectShadowExpAspectProperties> getMap() {
    return map;
  }
}
