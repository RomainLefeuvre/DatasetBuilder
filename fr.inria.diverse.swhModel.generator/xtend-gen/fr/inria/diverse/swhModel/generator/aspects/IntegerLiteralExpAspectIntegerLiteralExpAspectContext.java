package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.IntegerLiteralExp;

@SuppressWarnings("all")
public class IntegerLiteralExpAspectIntegerLiteralExpAspectContext {
  public static final IntegerLiteralExpAspectIntegerLiteralExpAspectContext INSTANCE = new IntegerLiteralExpAspectIntegerLiteralExpAspectContext();
  
  public static IntegerLiteralExpAspectIntegerLiteralExpAspectProperties getSelf(final IntegerLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspectIntegerLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IntegerLiteralExp, IntegerLiteralExpAspectIntegerLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.IntegerLiteralExp, fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspectIntegerLiteralExpAspectProperties>();
  
  public Map<IntegerLiteralExp, IntegerLiteralExpAspectIntegerLiteralExpAspectProperties> getMap() {
    return map;
  }
}
