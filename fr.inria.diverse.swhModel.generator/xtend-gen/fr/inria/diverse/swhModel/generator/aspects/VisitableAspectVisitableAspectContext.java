package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.utilities.Visitable;

@SuppressWarnings("all")
public class VisitableAspectVisitableAspectContext {
  public static final VisitableAspectVisitableAspectContext INSTANCE = new VisitableAspectVisitableAspectContext();
  
  public static VisitableAspectVisitableAspectProperties getSelf(final Visitable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.VisitableAspectVisitableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Visitable, VisitableAspectVisitableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.utilities.Visitable, fr.inria.diverse.swhModel.generator.aspects.VisitableAspectVisitableAspectProperties>();
  
  public Map<Visitable, VisitableAspectVisitableAspectProperties> getMap() {
    return map;
  }
}
