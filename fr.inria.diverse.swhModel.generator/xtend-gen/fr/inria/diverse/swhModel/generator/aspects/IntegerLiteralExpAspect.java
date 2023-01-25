package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = IntegerLiteralExp.class)
@SuppressWarnings("all")
public class IntegerLiteralExpAspect extends NumericLiteralExpAspect {
  public static String generate(final IntegerLiteralExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspectIntegerLiteralExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspectIntegerLiteralExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.IntegerLiteralExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.IntegerLiteralExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final IntegerLiteralExpAspectIntegerLiteralExpAspectProperties _self_, final IntegerLiteralExp _self, final Context context) {
    StringConcatenation _builder = new StringConcatenation();
    Number _integerSymbol = _self.getIntegerSymbol();
    _builder.append(_integerSymbol);
    return _builder.toString();
  }
}
