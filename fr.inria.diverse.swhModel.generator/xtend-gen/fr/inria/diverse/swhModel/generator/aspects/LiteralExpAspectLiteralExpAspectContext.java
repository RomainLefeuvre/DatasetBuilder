package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.LiteralExp;

@SuppressWarnings("all")
public class LiteralExpAspectLiteralExpAspectContext {
  public static final LiteralExpAspectLiteralExpAspectContext INSTANCE = new LiteralExpAspectLiteralExpAspectContext();
  
  public static LiteralExpAspectLiteralExpAspectProperties getSelf(final LiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LiteralExpAspectLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LiteralExp, LiteralExpAspectLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.LiteralExp, fr.inria.diverse.swhModel.generator.aspects.LiteralExpAspectLiteralExpAspectProperties>();
  
  public Map<LiteralExp, LiteralExpAspectLiteralExpAspectProperties> getMap() {
    return map;
  }
}
