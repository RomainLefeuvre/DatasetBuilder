package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.MapType;

@SuppressWarnings("all")
public class MapTypeAspectMapTypeAspectContext {
  public static final MapTypeAspectMapTypeAspectContext INSTANCE = new MapTypeAspectMapTypeAspectContext();
  
  public static MapTypeAspectMapTypeAspectProperties getSelf(final MapType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.MapTypeAspectMapTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MapType, MapTypeAspectMapTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.MapType, fr.inria.diverse.swhModel.generator.aspects.MapTypeAspectMapTypeAspectProperties>();
  
  public Map<MapType, MapTypeAspectMapTypeAspectProperties> getMap() {
    return map;
  }
}
