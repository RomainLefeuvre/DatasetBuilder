package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.ExpressionInOCL;

@Aspect(className = ExpressionInOCL.class)
@SuppressWarnings("all")
public class ExpressionInOCLAspect extends LanguageExpressionAspect {
  public static String generate(final ExpressionInOCL _self, final Context c) {
    final fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspectExpressionInOCLAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspectExpressionInOCLAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.ExpressionInOCL){
    	result = fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.ExpressionInOCL)_self,c);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final ExpressionInOCLAspectExpressionInOCLAspectProperties _self_, final ExpressionInOCL _self, final Context c) {
    return OCLExpressionAspect.generate(_self.getOwnedBody(), c);
  }
}
