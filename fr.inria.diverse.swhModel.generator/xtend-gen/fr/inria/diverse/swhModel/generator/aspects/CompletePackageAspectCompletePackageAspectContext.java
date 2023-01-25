package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CompletePackage;

@SuppressWarnings("all")
public class CompletePackageAspectCompletePackageAspectContext {
  public static final CompletePackageAspectCompletePackageAspectContext INSTANCE = new CompletePackageAspectCompletePackageAspectContext();
  
  public static CompletePackageAspectCompletePackageAspectProperties getSelf(final CompletePackage _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CompletePackageAspectCompletePackageAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CompletePackage, CompletePackageAspectCompletePackageAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CompletePackage, fr.inria.diverse.swhModel.generator.aspects.CompletePackageAspectCompletePackageAspectProperties>();
  
  public Map<CompletePackage, CompletePackageAspectCompletePackageAspectProperties> getMap() {
    return map;
  }
}
