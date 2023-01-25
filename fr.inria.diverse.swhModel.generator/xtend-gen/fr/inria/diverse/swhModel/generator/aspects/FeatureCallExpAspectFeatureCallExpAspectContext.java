package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.FeatureCallExp;

@SuppressWarnings("all")
public class FeatureCallExpAspectFeatureCallExpAspectContext {
  public static final FeatureCallExpAspectFeatureCallExpAspectContext INSTANCE = new FeatureCallExpAspectFeatureCallExpAspectContext();
  
  public static FeatureCallExpAspectFeatureCallExpAspectProperties getSelf(final FeatureCallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.FeatureCallExpAspectFeatureCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FeatureCallExp, FeatureCallExpAspectFeatureCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.FeatureCallExp, fr.inria.diverse.swhModel.generator.aspects.FeatureCallExpAspectFeatureCallExpAspectProperties>();
  
  public Map<FeatureCallExp, FeatureCallExpAspectFeatureCallExpAspectProperties> getMap() {
    return map;
  }
}
