package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = IfExp.class)
@SuppressWarnings("all")
public class IfExpAspect extends OCLExpressionAspect {
  public static String generate(final IfExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.IfExpAspectIfExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.IfExpAspectIfExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.IfExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.IfExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.IfExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final IfExpAspectIfExpAspectProperties _self_, final IfExp _self, final Context context) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    String _generate = OCLExpressionAspect.generate(_self.getOwnedCondition(), context);
    _builder.append(_generate);
    _builder.append(")?");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(");
    String _generate_1 = OCLExpressionAspect.generate(_self.getOwnedThen(), context);
    _builder.append(_generate_1, "\t");
    _builder.append("):");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("(");
    String _generate_2 = OCLExpressionAspect.generate(_self.getOwnedElse(), context);
    _builder.append(_generate_2, "\t");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append(")\t\t");
    _builder.newLine();
    return _builder.toString();
  }
}
