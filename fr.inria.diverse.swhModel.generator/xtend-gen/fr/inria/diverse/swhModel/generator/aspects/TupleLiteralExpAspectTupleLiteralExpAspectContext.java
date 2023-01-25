package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TupleLiteralExp;

@SuppressWarnings("all")
public class TupleLiteralExpAspectTupleLiteralExpAspectContext {
  public static final TupleLiteralExpAspectTupleLiteralExpAspectContext INSTANCE = new TupleLiteralExpAspectTupleLiteralExpAspectContext();
  
  public static TupleLiteralExpAspectTupleLiteralExpAspectProperties getSelf(final TupleLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TupleLiteralExpAspectTupleLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TupleLiteralExp, TupleLiteralExpAspectTupleLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TupleLiteralExp, fr.inria.diverse.swhModel.generator.aspects.TupleLiteralExpAspectTupleLiteralExpAspectProperties>();
  
  public Map<TupleLiteralExp, TupleLiteralExpAspectTupleLiteralExpAspectProperties> getMap() {
    return map;
  }
}
