package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;

@SuppressWarnings("all")
public class PackageAspectPackageAspectContext {
  public static final PackageAspectPackageAspectContext INSTANCE = new PackageAspectPackageAspectContext();
  
  public static PackageAspectPackageAspectProperties getSelf(final org.eclipse.ocl.pivot.Package _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PackageAspectPackageAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<org.eclipse.ocl.pivot.Package, PackageAspectPackageAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Package, fr.inria.diverse.swhModel.generator.aspects.PackageAspectPackageAspectProperties>();
  
  public Map<org.eclipse.ocl.pivot.Package, PackageAspectPackageAspectProperties> getMap() {
    return map;
  }
}
