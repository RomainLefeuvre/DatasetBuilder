package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.VariableExp;

@Aspect(className = VariableExp.class)
@SuppressWarnings("all")
public class VariableExpAspect extends OCLExpressionAspect {
  /**
   * BE CAREFUL :
   * 
   * This class has more than one superclass
   * please specify which parent you want with the 'super' expected calling
   */
  public static String generate(final VariableExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.VariableExpAspectVariableExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.VariableExpAspectVariableExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.VariableExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.VariableExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.VariableExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final VariableExpAspectVariableExpAspectProperties _self_, final VariableExp _self, final Context context) {
    String _switchResult = null;
    String _name = _self.getName();
    if (_name != null) {
      switch (_name) {
        case "1_":
          _switchResult = context.getIteratorVariable();
          break;
        default:
          _switchResult = _self.getName();
          break;
      }
    } else {
      _switchResult = _self.getName();
    }
    return _switchResult;
  }
}
