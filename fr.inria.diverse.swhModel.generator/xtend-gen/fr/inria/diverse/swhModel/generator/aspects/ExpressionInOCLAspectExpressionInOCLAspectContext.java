package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ExpressionInOCL;

@SuppressWarnings("all")
public class ExpressionInOCLAspectExpressionInOCLAspectContext {
  public static final ExpressionInOCLAspectExpressionInOCLAspectContext INSTANCE = new ExpressionInOCLAspectExpressionInOCLAspectContext();
  
  public static ExpressionInOCLAspectExpressionInOCLAspectProperties getSelf(final ExpressionInOCL _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspectExpressionInOCLAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ExpressionInOCL, ExpressionInOCLAspectExpressionInOCLAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ExpressionInOCL, fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspectExpressionInOCLAspectProperties>();
  
  public Map<ExpressionInOCL, ExpressionInOCLAspectExpressionInOCLAspectProperties> getMap() {
    return map;
  }
}
