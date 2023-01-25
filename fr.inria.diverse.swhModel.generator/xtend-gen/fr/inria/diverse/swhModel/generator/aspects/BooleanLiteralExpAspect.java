package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = BooleanLiteralExp.class)
@SuppressWarnings("all")
public class BooleanLiteralExpAspect extends PrimitiveLiteralExpAspect {
  public static String generate(final BooleanLiteralExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspectBooleanLiteralExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspectBooleanLiteralExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.BooleanLiteralExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.BooleanLiteralExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final BooleanLiteralExpAspectBooleanLiteralExpAspectProperties _self_, final BooleanLiteralExp _self, final Context context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    return _builder.toString();
  }
}
