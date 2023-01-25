package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Model;

@SuppressWarnings("all")
public class Pivot_ModelAspectModelAspectContext {
  public static final Pivot_ModelAspectModelAspectContext INSTANCE = new Pivot_ModelAspectModelAspectContext();
  
  public static Pivot_ModelAspectModelAspectProperties getSelf(final Model _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspectModelAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Model, Pivot_ModelAspectModelAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Model, fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspectModelAspectProperties>();
  
  public Map<Model, Pivot_ModelAspectModelAspectProperties> getMap() {
    return map;
  }
}
