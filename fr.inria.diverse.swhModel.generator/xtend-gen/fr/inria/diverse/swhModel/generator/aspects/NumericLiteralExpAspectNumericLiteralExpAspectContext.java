package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.NumericLiteralExp;

@SuppressWarnings("all")
public class NumericLiteralExpAspectNumericLiteralExpAspectContext {
  public static final NumericLiteralExpAspectNumericLiteralExpAspectContext INSTANCE = new NumericLiteralExpAspectNumericLiteralExpAspectContext();
  
  public static NumericLiteralExpAspectNumericLiteralExpAspectProperties getSelf(final NumericLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NumericLiteralExpAspectNumericLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NumericLiteralExp, NumericLiteralExpAspectNumericLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.NumericLiteralExp, fr.inria.diverse.swhModel.generator.aspects.NumericLiteralExpAspectNumericLiteralExpAspectProperties>();
  
  public Map<NumericLiteralExp, NumericLiteralExpAspectNumericLiteralExpAspectProperties> getMap() {
    return map;
  }
}
