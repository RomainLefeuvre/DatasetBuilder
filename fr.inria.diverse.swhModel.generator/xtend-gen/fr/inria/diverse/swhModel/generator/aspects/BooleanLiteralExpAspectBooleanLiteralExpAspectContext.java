package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.BooleanLiteralExp;

@SuppressWarnings("all")
public class BooleanLiteralExpAspectBooleanLiteralExpAspectContext {
  public static final BooleanLiteralExpAspectBooleanLiteralExpAspectContext INSTANCE = new BooleanLiteralExpAspectBooleanLiteralExpAspectContext();
  
  public static BooleanLiteralExpAspectBooleanLiteralExpAspectProperties getSelf(final BooleanLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspectBooleanLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<BooleanLiteralExp, BooleanLiteralExpAspectBooleanLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.BooleanLiteralExp, fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspectBooleanLiteralExpAspectProperties>();
  
  public Map<BooleanLiteralExp, BooleanLiteralExpAspectBooleanLiteralExpAspectProperties> getMap() {
    return map;
  }
}
