package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.BagType;

@SuppressWarnings("all")
public class BagTypeAspectBagTypeAspectContext {
  public static final BagTypeAspectBagTypeAspectContext INSTANCE = new BagTypeAspectBagTypeAspectContext();
  
  public static BagTypeAspectBagTypeAspectProperties getSelf(final BagType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.BagTypeAspectBagTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BagType, BagTypeAspectBagTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.BagType, fr.inria.diverse.swhModel.generator.aspects.BagTypeAspectBagTypeAspectProperties>();
  
  public Map<BagType, BagTypeAspectBagTypeAspectProperties> getMap() {
    return map;
  }
}
