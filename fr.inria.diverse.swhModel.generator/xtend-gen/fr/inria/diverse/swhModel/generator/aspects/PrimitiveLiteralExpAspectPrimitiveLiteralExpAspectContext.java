package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;

@SuppressWarnings("all")
public class PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectContext {
  public static final PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectContext INSTANCE = new PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectContext();
  
  public static PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties getSelf(final PrimitiveLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<PrimitiveLiteralExp, PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.PrimitiveLiteralExp, fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties>();
  
  public Map<PrimitiveLiteralExp, PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties> getMap() {
    return map;
  }
}
