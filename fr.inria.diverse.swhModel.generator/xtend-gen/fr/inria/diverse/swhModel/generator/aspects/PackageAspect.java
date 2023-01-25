package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = org.eclipse.ocl.pivot.Package.class)
@SuppressWarnings("all")
public class PackageAspect extends NamespaceAspect {
  public static String generate(final org.eclipse.ocl.pivot.Package _self, final String queryId) {
    final fr.inria.diverse.swhModel.generator.aspects.PackageAspectPackageAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.PackageAspectPackageAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(String)
    if (_self instanceof org.eclipse.ocl.pivot.Package){
    	result = fr.inria.diverse.swhModel.generator.aspects.PackageAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.Package)_self,queryId);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final PackageAspectPackageAspectProperties _self_, final org.eclipse.ocl.pivot.Package _self, final String queryId) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<org.eclipse.ocl.pivot.Class> _ownedClasses = _self.getOwnedClasses();
      for(final org.eclipse.ocl.pivot.Class ownedClass : _ownedClasses) {
        String _generate = ClassAspect.generate(ownedClass, queryId);
        _builder.append(_generate);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
}
