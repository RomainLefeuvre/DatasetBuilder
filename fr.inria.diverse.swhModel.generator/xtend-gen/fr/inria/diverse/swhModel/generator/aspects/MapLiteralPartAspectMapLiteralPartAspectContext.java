package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.MapLiteralPart;

@SuppressWarnings("all")
public class MapLiteralPartAspectMapLiteralPartAspectContext {
  public static final MapLiteralPartAspectMapLiteralPartAspectContext INSTANCE = new MapLiteralPartAspectMapLiteralPartAspectContext();
  
  public static MapLiteralPartAspectMapLiteralPartAspectProperties getSelf(final MapLiteralPart _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.MapLiteralPartAspectMapLiteralPartAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MapLiteralPart, MapLiteralPartAspectMapLiteralPartAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.MapLiteralPart, fr.inria.diverse.swhModel.generator.aspects.MapLiteralPartAspectMapLiteralPartAspectProperties>();
  
  public Map<MapLiteralPart, MapLiteralPartAspectMapLiteralPartAspectProperties> getMap() {
    return map;
  }
}
