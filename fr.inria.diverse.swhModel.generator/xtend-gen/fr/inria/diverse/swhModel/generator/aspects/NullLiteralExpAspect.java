package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.NullLiteralExp;

@Aspect(className = NullLiteralExp.class)
@SuppressWarnings("all")
public class NullLiteralExpAspect extends PrimitiveLiteralExpAspect {
  public static String generate(final NullLiteralExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.NullLiteralExpAspectNullLiteralExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.NullLiteralExpAspectNullLiteralExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.NullLiteralExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.NullLiteralExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.NullLiteralExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final NullLiteralExpAspectNullLiteralExpAspectProperties _self_, final NullLiteralExp _self, final Context context) {
    return "null";
  }
}
