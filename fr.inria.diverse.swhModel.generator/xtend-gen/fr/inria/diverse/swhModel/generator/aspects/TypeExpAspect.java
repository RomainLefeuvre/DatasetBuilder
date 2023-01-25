package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = TypeExp.class)
@SuppressWarnings("all")
public class TypeExpAspect extends OCLExpressionAspect {
  /**
   * BE CAREFUL :
   * 
   * This class has more than one superclass
   * please specify which parent you want with the 'super' expected calling
   */
  public static String generate(final TypeExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.TypeExpAspectTypeExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.TypeExpAspectTypeExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.TypeExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.TypeExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.TypeExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final TypeExpAspectTypeExpAspectProperties _self_, final TypeExp _self, final Context context) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = _self.getName();
    _builder.append(_name);
    return _builder.toString();
  }
}
