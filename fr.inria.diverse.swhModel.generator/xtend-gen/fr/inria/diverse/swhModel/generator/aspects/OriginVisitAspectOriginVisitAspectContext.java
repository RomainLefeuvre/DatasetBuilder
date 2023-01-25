package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.OriginVisit;
import java.util.Map;

@SuppressWarnings("all")
public class OriginVisitAspectOriginVisitAspectContext {
  public static final OriginVisitAspectOriginVisitAspectContext INSTANCE = new OriginVisitAspectOriginVisitAspectContext();
  
  public static OriginVisitAspectOriginVisitAspectProperties getSelf(final OriginVisit _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OriginVisitAspectOriginVisitAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OriginVisit, OriginVisitAspectOriginVisitAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.OriginVisit, fr.inria.diverse.swhModel.generator.aspects.OriginVisitAspectOriginVisitAspectProperties>();
  
  public Map<OriginVisit, OriginVisitAspectOriginVisitAspectProperties> getMap() {
    return map;
  }
}
