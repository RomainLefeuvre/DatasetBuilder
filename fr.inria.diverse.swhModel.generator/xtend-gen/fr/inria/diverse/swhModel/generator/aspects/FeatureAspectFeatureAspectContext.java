package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Feature;

@SuppressWarnings("all")
public class FeatureAspectFeatureAspectContext {
  public static final FeatureAspectFeatureAspectContext INSTANCE = new FeatureAspectFeatureAspectContext();
  
  public static FeatureAspectFeatureAspectProperties getSelf(final Feature _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.FeatureAspectFeatureAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Feature, FeatureAspectFeatureAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Feature, fr.inria.diverse.swhModel.generator.aspects.FeatureAspectFeatureAspectProperties>();
  
  public Map<Feature, FeatureAspectFeatureAspectProperties> getMap() {
    return map;
  }
}
