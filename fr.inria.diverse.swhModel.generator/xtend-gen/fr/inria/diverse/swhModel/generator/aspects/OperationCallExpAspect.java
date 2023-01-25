package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = OperationCallExp.class)
@SuppressWarnings("all")
public class OperationCallExpAspect extends FeatureCallExpAspect {
  /**
   * BE CAREFUL :
   * 
   * This class has more than one superclass
   * please specify which parent you want with the 'super' expected calling
   */
  public static String generate(final OperationCallExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspectOperationCallExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspectOperationCallExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.OperationCallExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.OperationCallExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final OperationCallExpAspectOperationCallExpAspectProperties _self_, final OperationCallExp _self, final Context context) {
    String _xblockexpression = null;
    {
      final String source = OCLExpressionAspect.generate(_self.getOwnedSource(), context);
      String _switchResult = null;
      String _name = _self.getName();
      if (_name != null) {
        switch (_name) {
          case "oclAsSet":
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("(new HashSet<");
            String _name_1 = _self.getOwnedSource().getType().getName();
            _builder.append(_name_1);
            _builder.append(">(Arrays.asList(");
            _builder.append(source);
            _builder.append(")))");
            _switchResult = _builder.toString();
            break;
          case "asSet":
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("(new HashSet<");
            String _name_2 = _self.getOwnedSource().getType().getName();
            _builder_1.append(_name_2);
            _builder_1.append(">(Arrays.asList(");
            _builder_1.append(source);
            _builder_1.append(")))");
            _switchResult = _builder_1.toString();
            break;
          case "oclIsKindOf":
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("(");
            _builder_2.append(source);
            _builder_2.append(" instanceof ");
            String _generate = OCLExpressionAspect.generate(_self.getOwnedArguments().get(0), context);
            _builder_2.append(_generate);
            _builder_2.append(")");
            _switchResult = _builder_2.toString();
            break;
          case "oclAsType":
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("((");
            String _generate_1 = OCLExpressionAspect.generate(_self.getOwnedArguments().get(0), context);
            _builder_3.append(_generate_1);
            _builder_3.append(") ");
            _builder_3.append(source);
            _builder_3.append(")");
            _switchResult = _builder_3.toString();
            break;
          case "first":
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append(source);
            _builder_4.append(".get(0)");
            _switchResult = _builder_4.toString();
            break;
          case "=":
            String _xblockexpression_1 = null;
            {
              OCLExpression _get = _self.getOwnedArguments().get(0);
              final OCLExpression value = ((OCLExpression) _get);
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append(source);
              _builder_5.append(".equals(");
              String _generate_2 = OCLExpressionAspect.generate(value, context);
              _builder_5.append(_generate_2);
              _builder_5.append(")");
              _xblockexpression_1 = _builder_5.toString();
            }
            _switchResult = _xblockexpression_1;
            break;
          case ">":
            String _xblockexpression_2 = null;
            {
              OCLExpression _get = _self.getOwnedArguments().get(0);
              final OCLExpression value = ((OCLExpression) _get);
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append(source);
              _builder_5.append(" > (");
              String _generate_2 = OCLExpressionAspect.generate(value, context);
              _builder_5.append(_generate_2);
              _builder_5.append(")");
              _xblockexpression_2 = _builder_5.toString();
            }
            _switchResult = _xblockexpression_2;
            break;
          case "<":
            String _xblockexpression_3 = null;
            {
              OCLExpression _get = _self.getOwnedArguments().get(0);
              final OCLExpression value = ((OCLExpression) _get);
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append(source);
              _builder_5.append(" < (");
              String _generate_2 = OCLExpressionAspect.generate(value, context);
              _builder_5.append(_generate_2);
              _builder_5.append(")");
              _xblockexpression_3 = _builder_5.toString();
            }
            _switchResult = _xblockexpression_3;
            break;
          case "or":
            String _xblockexpression_4 = null;
            {
              OCLExpression _get = _self.getOwnedArguments().get(0);
              final OCLExpression value = ((OCLExpression) _get);
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append("(");
              _builder_5.append(source);
              _builder_5.append(" || ");
              _builder_5.newLineIfNotEmpty();
              _builder_5.append("\t");
              String _generate_2 = OCLExpressionAspect.generate(value, context);
              _builder_5.append(_generate_2, "\t");
              _builder_5.append(")");
              _builder_5.newLineIfNotEmpty();
              _xblockexpression_4 = _builder_5.toString();
            }
            _switchResult = _xblockexpression_4;
            break;
          case "and":
            String _xblockexpression_5 = null;
            {
              OCLExpression _get = _self.getOwnedArguments().get(0);
              final OCLExpression value = ((OCLExpression) _get);
              StringConcatenation _builder_5 = new StringConcatenation();
              _builder_5.append("(");
              _builder_5.append(source);
              _builder_5.append(" && ");
              _builder_5.newLineIfNotEmpty();
              _builder_5.append("\t");
              String _generate_2 = OCLExpressionAspect.generate(value, context);
              _builder_5.append(_generate_2, "\t");
              _builder_5.append(")");
              _builder_5.newLineIfNotEmpty();
              _xblockexpression_5 = _builder_5.toString();
            }
            _switchResult = _xblockexpression_5;
            break;
          default:
            String _switchResult_1 = null;
            int _size = _self.getOwnedArguments().size();
            switch (_size) {
              case 0:
                StringConcatenation _builder_5 = new StringConcatenation();
                _builder_5.append(source);
                _builder_5.append(".");
                String _name_3 = _self.getName();
                _builder_5.append(_name_3);
                _builder_5.append("()");
                _switchResult_1 = _builder_5.toString();
                break;
              case 1:
                String _xblockexpression_6 = null;
                {
                  OCLExpression _get = _self.getOwnedArguments().get(0);
                  final OCLExpression value = ((OCLExpression) _get);
                  StringConcatenation _builder_6 = new StringConcatenation();
                  _builder_6.append(source);
                  _builder_6.append(" ");
                  String _name_4 = _self.getName();
                  _builder_6.append(_name_4);
                  _builder_6.append(" (");
                  String _generate_2 = OCLExpressionAspect.generate(value, context);
                  _builder_6.append(_generate_2);
                  _builder_6.append(")");
                  _xblockexpression_6 = _builder_6.toString();
                }
                _switchResult_1 = _xblockexpression_6;
                break;
            }
            _switchResult = _switchResult_1;
            break;
        }
      } else {
        String _switchResult_1 = null;
        int _size = _self.getOwnedArguments().size();
        switch (_size) {
          case 0:
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append(source);
            _builder_5.append(".");
            String _name_3 = _self.getName();
            _builder_5.append(_name_3);
            _builder_5.append("()");
            _switchResult_1 = _builder_5.toString();
            break;
          case 1:
            String _xblockexpression_6 = null;
            {
              OCLExpression _get = _self.getOwnedArguments().get(0);
              final OCLExpression value = ((OCLExpression) _get);
              StringConcatenation _builder_6 = new StringConcatenation();
              _builder_6.append(source);
              _builder_6.append(" ");
              String _name_4 = _self.getName();
              _builder_6.append(_name_4);
              _builder_6.append(" (");
              String _generate_2 = OCLExpressionAspect.generate(value, context);
              _builder_6.append(_generate_2);
              _builder_6.append(")");
              _xblockexpression_6 = _builder_6.toString();
            }
            _switchResult_1 = _xblockexpression_6;
            break;
        }
        _switchResult = _switchResult_1;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
