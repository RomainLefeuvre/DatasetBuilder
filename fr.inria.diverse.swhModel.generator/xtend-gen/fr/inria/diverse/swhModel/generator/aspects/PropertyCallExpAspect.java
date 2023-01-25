package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Aspect(className = PropertyCallExp.class)
@SuppressWarnings("all")
public class PropertyCallExpAspect extends NavigationCallExpAspect {
  /**
   * BE CAREFUL :
   * 
   * This class has more than one superclass
   * please specify which parent you want with the 'super' expected calling
   */
  public static String generate(final PropertyCallExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspectPropertyCallExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspectPropertyCallExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.PropertyCallExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.PropertyCallExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final PropertyCallExpAspectPropertyCallExpAspectProperties _self_, final PropertyCallExp _self, final Context context) {
    String _xblockexpression = null;
    {
      final String sourceAttribute = OCLExpressionAspect.generate(_self.getOwnedSource(), context);
      String _firstUpper = StringExtensions.toFirstUpper(_self.getName());
      String _plus = ("get" + _firstUpper);
      final String getter = (_plus + "()");
      String _switchResult = null;
      if (sourceAttribute != null) {
        switch (sourceAttribute) {
          case "self":
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("this.g.");
            _builder.append(getter);
            _switchResult = _builder.toString();
            break;
          case "1_":
            StringConcatenation _builder_1 = new StringConcatenation();
            String _iteratorVariable = context.getIteratorVariable();
            _builder_1.append(_iteratorVariable);
            _builder_1.append(".");
            _builder_1.append(getter);
            _switchResult = _builder_1.toString();
            break;
          default:
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(sourceAttribute);
            _builder_2.append(".");
            _builder_2.append(getter);
            _switchResult = _builder_2.toString();
            break;
        }
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(sourceAttribute);
        _builder_2.append(".");
        _builder_2.append(getter);
        _switchResult = _builder_2.toString();
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
