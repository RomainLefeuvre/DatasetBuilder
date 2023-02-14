package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.ParameterVariable;

@Aspect(className = ParameterVariable.class)
@SuppressWarnings("all")
public class ParameterVariableAspect extends VariableAspect {
  public static String generate(final ParameterVariable _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.ParameterVariableAspectParameterVariableAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.ParameterVariableAspectParameterVariableAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.ParameterVariable){
    	result = fr.inria.diverse.swhModel.generator.aspects.ParameterVariableAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.ParameterVariable)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final ParameterVariableAspectParameterVariableAspectProperties _self_, final ParameterVariable _self, final Context context) {
    return null;
  }
}
