package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.AssociationClassCallExp;

@SuppressWarnings("all")
public class AssociationClassCallExpAspectAssociationClassCallExpAspectContext {
  public static final AssociationClassCallExpAspectAssociationClassCallExpAspectContext INSTANCE = new AssociationClassCallExpAspectAssociationClassCallExpAspectContext();
  
  public static AssociationClassCallExpAspectAssociationClassCallExpAspectProperties getSelf(final AssociationClassCallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.AssociationClassCallExpAspectAssociationClassCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<AssociationClassCallExp, AssociationClassCallExpAspectAssociationClassCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.AssociationClassCallExp, fr.inria.diverse.swhModel.generator.aspects.AssociationClassCallExpAspectAssociationClassCallExpAspectProperties>();
  
  public Map<AssociationClassCallExp, AssociationClassCallExpAspectAssociationClassCallExpAspectProperties> getMap() {
    return map;
  }
}
