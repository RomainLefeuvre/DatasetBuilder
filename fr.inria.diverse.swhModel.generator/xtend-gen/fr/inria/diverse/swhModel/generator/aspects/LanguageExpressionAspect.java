package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.LanguageExpression;

@Aspect(className = LanguageExpression.class)
@SuppressWarnings("all")
public abstract class LanguageExpressionAspect extends ValueSpecificationAspect {
  public static String generate(final LanguageExpression _self, final Context c) {
    final fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspectLanguageExpressionAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspectLanguageExpressionAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspect
    		if (_self instanceof org.eclipse.ocl.pivot.ExpressionInOCL){
    			result = fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspect.generate((org.eclipse.ocl.pivot.ExpressionInOCL)_self,c);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspect
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.LanguageExpression){
    	result = fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.LanguageExpression)_self,c);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final LanguageExpressionAspectLanguageExpressionAspectProperties _self_, final LanguageExpression _self, final Context c) {
    return null;
  }
}
