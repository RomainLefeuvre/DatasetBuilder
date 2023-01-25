package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.OrphanCompletePackage;

@SuppressWarnings("all")
public class OrphanCompletePackageAspectOrphanCompletePackageAspectContext {
  public static final OrphanCompletePackageAspectOrphanCompletePackageAspectContext INSTANCE = new OrphanCompletePackageAspectOrphanCompletePackageAspectContext();
  
  public static OrphanCompletePackageAspectOrphanCompletePackageAspectProperties getSelf(final OrphanCompletePackage _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OrphanCompletePackageAspectOrphanCompletePackageAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OrphanCompletePackage, OrphanCompletePackageAspectOrphanCompletePackageAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.OrphanCompletePackage, fr.inria.diverse.swhModel.generator.aspects.OrphanCompletePackageAspectOrphanCompletePackageAspectProperties>();
  
  public Map<OrphanCompletePackage, OrphanCompletePackageAspectOrphanCompletePackageAspectProperties> getMap() {
    return map;
  }
}
