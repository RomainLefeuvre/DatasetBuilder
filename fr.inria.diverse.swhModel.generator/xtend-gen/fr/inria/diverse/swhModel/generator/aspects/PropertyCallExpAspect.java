package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Aspect(className = PropertyCallExp.class)
@SuppressWarnings("all")
public class PropertyCallExpAspect extends NavigationCallExpAspect {
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
            String _xifexpression = null;
            boolean _equals = context.getCurrentClass().equals("Graph");
            if (_equals) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("this.g.");
              _builder.append(getter);
              _xifexpression = _builder.toString();
            } else {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append(sourceAttribute);
              _builder_1.append(".");
              _builder_1.append(getter);
              _xifexpression = _builder_1.toString();
            }
            _switchResult = _xifexpression;
            break;
          case "1_":
            StringConcatenation _builder_2 = new StringConcatenation();
            String _iteratorVariable = context.getIteratorVariable();
            _builder_2.append(_iteratorVariable);
            _builder_2.append(".");
            _builder_2.append(getter);
            _switchResult = _builder_2.toString();
            break;
          default:
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append(sourceAttribute);
            _builder_3.append(".");
            _builder_3.append(getter);
            _switchResult = _builder_3.toString();
            break;
        }
      } else {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(sourceAttribute);
        _builder_3.append(".");
        _builder_3.append(getter);
        _switchResult = _builder_3.toString();
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
