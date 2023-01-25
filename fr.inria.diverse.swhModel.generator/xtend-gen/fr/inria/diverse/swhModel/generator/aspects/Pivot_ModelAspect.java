package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = Model.class)
@SuppressWarnings("all")
public class Pivot_ModelAspect extends NamespaceAspect {
  public static String generate(final Model _self, final String queryId) {
    final fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspectModelAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspectModelAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(String)
    if (_self instanceof org.eclipse.ocl.pivot.Model){
    	result = fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.Model)_self,queryId);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final Pivot_ModelAspectModelAspectProperties _self_, final Model _self, final String queryId) {
    StringConcatenation _builder = new StringConcatenation();
    String _generate = PackageAspect.generate(_self.getOwnedPackages().get(0), queryId);
    _builder.append(_generate);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
