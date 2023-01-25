package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Origin;
import java.util.Map;

@SuppressWarnings("all")
public class OriginAspectOriginAspectContext {
  public static final OriginAspectOriginAspectContext INSTANCE = new OriginAspectOriginAspectContext();
  
  public static OriginAspectOriginAspectProperties getSelf(final Origin _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OriginAspectOriginAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Origin, OriginAspectOriginAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Origin, fr.inria.diverse.swhModel.generator.aspects.OriginAspectOriginAspectProperties>();
  
  public Map<Origin, OriginAspectOriginAspectProperties> getMap() {
    return map;
  }
}
