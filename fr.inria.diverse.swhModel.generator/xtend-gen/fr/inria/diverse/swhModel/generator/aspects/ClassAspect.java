package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.List;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = org.eclipse.ocl.pivot.Class.class)
@SuppressWarnings("all")
public class ClassAspect extends TypeAspect {
  public static String generate(final org.eclipse.ocl.pivot.Class _self, final Context c) {
    final fr.inria.diverse.swhModel.generator.aspects.ClassAspectClassAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.ClassAspectClassAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.Class){
    	result = fr.inria.diverse.swhModel.generator.aspects.ClassAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.Class)_self,c);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final ClassAspectClassAspectProperties _self_, final org.eclipse.ocl.pivot.Class _self, final Context c) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Operation> _ownedOperations = _self.getOwnedOperations();
      for(final Operation operation : _ownedOperations) {
        String _generate = OperationAspect.generate(operation, c.clone());
        _builder.append(_generate);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
}
