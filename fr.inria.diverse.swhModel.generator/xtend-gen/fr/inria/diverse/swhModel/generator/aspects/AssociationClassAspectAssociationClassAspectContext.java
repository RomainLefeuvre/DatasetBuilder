package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.AssociationClass;

@SuppressWarnings("all")
public class AssociationClassAspectAssociationClassAspectContext {
  public static final AssociationClassAspectAssociationClassAspectContext INSTANCE = new AssociationClassAspectAssociationClassAspectContext();
  
  public static AssociationClassAspectAssociationClassAspectProperties getSelf(final AssociationClass _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.AssociationClassAspectAssociationClassAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<AssociationClass, AssociationClassAspectAssociationClassAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.AssociationClass, fr.inria.diverse.swhModel.generator.aspects.AssociationClassAspectAssociationClassAspectProperties>();
  
  public Map<AssociationClass, AssociationClassAspectAssociationClassAspectProperties> getMap() {
    return map;
  }
}
