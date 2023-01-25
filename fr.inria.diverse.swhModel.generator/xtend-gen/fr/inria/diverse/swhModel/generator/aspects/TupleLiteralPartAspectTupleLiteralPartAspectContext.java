package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TupleLiteralPart;

@SuppressWarnings("all")
public class TupleLiteralPartAspectTupleLiteralPartAspectContext {
  public static final TupleLiteralPartAspectTupleLiteralPartAspectContext INSTANCE = new TupleLiteralPartAspectTupleLiteralPartAspectContext();
  
  public static TupleLiteralPartAspectTupleLiteralPartAspectProperties getSelf(final TupleLiteralPart _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TupleLiteralPartAspectTupleLiteralPartAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TupleLiteralPart, TupleLiteralPartAspectTupleLiteralPartAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TupleLiteralPart, fr.inria.diverse.swhModel.generator.aspects.TupleLiteralPartAspectTupleLiteralPartAspectProperties>();
  
  public Map<TupleLiteralPart, TupleLiteralPartAspectTupleLiteralPartAspectProperties> getMap() {
    return map;
  }
}
