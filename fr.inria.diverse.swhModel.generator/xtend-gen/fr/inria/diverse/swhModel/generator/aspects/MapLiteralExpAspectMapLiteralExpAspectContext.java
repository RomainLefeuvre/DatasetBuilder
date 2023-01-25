package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.MapLiteralExp;

@SuppressWarnings("all")
public class MapLiteralExpAspectMapLiteralExpAspectContext {
  public static final MapLiteralExpAspectMapLiteralExpAspectContext INSTANCE = new MapLiteralExpAspectMapLiteralExpAspectContext();
  
  public static MapLiteralExpAspectMapLiteralExpAspectProperties getSelf(final MapLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.MapLiteralExpAspectMapLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MapLiteralExp, MapLiteralExpAspectMapLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.MapLiteralExp, fr.inria.diverse.swhModel.generator.aspects.MapLiteralExpAspectMapLiteralExpAspectProperties>();
  
  public Map<MapLiteralExp, MapLiteralExpAspectMapLiteralExpAspectProperties> getMap() {
    return map;
  }
}
