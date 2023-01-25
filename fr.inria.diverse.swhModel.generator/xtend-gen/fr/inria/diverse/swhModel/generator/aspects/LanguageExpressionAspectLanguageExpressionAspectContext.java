package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.LanguageExpression;

@SuppressWarnings("all")
public class LanguageExpressionAspectLanguageExpressionAspectContext {
  public static final LanguageExpressionAspectLanguageExpressionAspectContext INSTANCE = new LanguageExpressionAspectLanguageExpressionAspectContext();
  
  public static LanguageExpressionAspectLanguageExpressionAspectProperties getSelf(final LanguageExpression _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspectLanguageExpressionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LanguageExpression, LanguageExpressionAspectLanguageExpressionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.LanguageExpression, fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspectLanguageExpressionAspectProperties>();
  
  public Map<LanguageExpression, LanguageExpressionAspectLanguageExpressionAspectProperties> getMap() {
    return map;
  }
}
