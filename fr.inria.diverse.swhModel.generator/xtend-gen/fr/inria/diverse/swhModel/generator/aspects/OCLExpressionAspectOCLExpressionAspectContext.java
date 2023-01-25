package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.OCLExpression;

@SuppressWarnings("all")
public class OCLExpressionAspectOCLExpressionAspectContext {
  public static final OCLExpressionAspectOCLExpressionAspectContext INSTANCE = new OCLExpressionAspectOCLExpressionAspectContext();
  
  public static OCLExpressionAspectOCLExpressionAspectProperties getSelf(final OCLExpression _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspectOCLExpressionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OCLExpression, OCLExpressionAspectOCLExpressionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.OCLExpression, fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspectOCLExpressionAspectProperties>();
  
  public Map<OCLExpression, OCLExpressionAspectOCLExpressionAspectProperties> getMap() {
    return map;
  }
}
