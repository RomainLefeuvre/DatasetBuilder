package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.PrimitiveCompletePackage;

@SuppressWarnings("all")
public class PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectContext {
  public static final PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectContext INSTANCE = new PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectContext();
  
  public static PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectProperties getSelf(final PrimitiveCompletePackage _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<PrimitiveCompletePackage, PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.PrimitiveCompletePackage, fr.inria.diverse.swhModel.generator.aspects.PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectProperties>();
  
  public Map<PrimitiveCompletePackage, PrimitiveCompletePackageAspectPrimitiveCompletePackageAspectProperties> getMap() {
    return map;
  }
}
