package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.RealLiteralExp;

@SuppressWarnings("all")
public class RealLiteralExpAspectRealLiteralExpAspectContext {
  public static final RealLiteralExpAspectRealLiteralExpAspectContext INSTANCE = new RealLiteralExpAspectRealLiteralExpAspectContext();
  
  public static RealLiteralExpAspectRealLiteralExpAspectProperties getSelf(final RealLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.RealLiteralExpAspectRealLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<RealLiteralExp, RealLiteralExpAspectRealLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.RealLiteralExp, fr.inria.diverse.swhModel.generator.aspects.RealLiteralExpAspectRealLiteralExpAspectProperties>();
  
  public Map<RealLiteralExp, RealLiteralExpAspectRealLiteralExpAspectProperties> getMap() {
    return map;
  }
}
