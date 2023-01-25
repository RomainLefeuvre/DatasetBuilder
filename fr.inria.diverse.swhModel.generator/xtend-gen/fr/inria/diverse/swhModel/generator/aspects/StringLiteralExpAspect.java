package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = StringLiteralExp.class)
@SuppressWarnings("all")
public class StringLiteralExpAspect extends PrimitiveLiteralExpAspect {
  public static String generate(final StringLiteralExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspectStringLiteralExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspectStringLiteralExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.StringLiteralExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.StringLiteralExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final StringLiteralExpAspectStringLiteralExpAspectProperties _self_, final StringLiteralExp _self, final Context context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _stringSymbol = _self.getStringSymbol();
    _builder.append(_stringSymbol);
    _builder.append("\"");
    return _builder.toString();
  }
}
