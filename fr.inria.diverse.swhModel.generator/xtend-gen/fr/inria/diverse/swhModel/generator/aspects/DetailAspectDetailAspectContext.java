package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Detail;

@SuppressWarnings("all")
public class DetailAspectDetailAspectContext {
  public static final DetailAspectDetailAspectContext INSTANCE = new DetailAspectDetailAspectContext();
  
  public static DetailAspectDetailAspectProperties getSelf(final Detail _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DetailAspectDetailAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Detail, DetailAspectDetailAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Detail, fr.inria.diverse.swhModel.generator.aspects.DetailAspectDetailAspectProperties>();
  
  public Map<Detail, DetailAspectDetailAspectProperties> getMap() {
    return map;
  }
}
