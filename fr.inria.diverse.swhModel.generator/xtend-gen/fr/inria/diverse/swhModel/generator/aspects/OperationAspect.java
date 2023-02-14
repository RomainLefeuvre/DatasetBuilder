package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = Operation.class)
@SuppressWarnings("all")
public class OperationAspect extends FeatureAspect {
  public static String generate(final Operation _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.OperationAspectOperationAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.OperationAspectOperationAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.Operation){
    	result = fr.inria.diverse.swhModel.generator.aspects.OperationAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.Operation)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final OperationAspectOperationAspectProperties _self_, final Operation _self, final Context context) {
    String _xblockexpression = null;
    {
      context.setCurrentClass(_self.getOwningClass().getName());
      String _switchResult = null;
      String _name = _self.getName();
      if (_name != null) {
        switch (_name) {
          case "query":
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("public Set<Long> runQuery() throws IOException, InterruptedException {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("Set<Long> results = new HashSet<>();");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("logger.info(\"------Executing query \"+id+\"------\");");
            _builder.newLine();
            _builder.append("\t");
            String _generate = LanguageExpressionAspect.generate(_self.getBodyExpression(), context);
            _builder.append(_generate, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return results;\t\t\t    ");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _switchResult = _builder.toString();
            break;
          default:
            String _xblockexpression_1 = null;
            {
              context.getGlobalContext().getContextMethods().put(_self.getName(), _self.getOwningClass().getName());
              LanguageExpression _bodyExpression = _self.getBodyExpression();
              OCLExpression _ownedBody = ((ExpressionInOCL) _bodyExpression).getOwnedBody();
              if ((_ownedBody instanceof IfExp)) {
                LanguageExpression _bodyExpression_1 = _self.getBodyExpression();
                OCLExpression _ownedBody_1 = ((ExpressionInOCL) _bodyExpression_1).getOwnedBody();
                final IfExp ifExp = ((IfExp) _ownedBody_1);
                if (((ifExp.getOwnedElse() instanceof OperationCallExp) && ifExp.getOwnedElse().getName().equals(_self.getName()))) {
                  OCLExpression _ownedElse = ifExp.getOwnedElse();
                  final OperationCallExp ownedElse = ((OperationCallExp) _ownedElse);
                  final String elseSource = OCLExpressionAspect.generate(ownedElse.getOwnedSource(), context);
                  StringConcatenation _builder_1 = new StringConcatenation();
                  _builder_1.append("public static ");
                  String _name_1 = _self.getType().getName();
                  _builder_1.append(_name_1);
                  _builder_1.append(" ");
                  String _name_2 = _self.getName();
                  _builder_1.append(_name_2);
                  _builder_1.append("( ");
                  String _name_3 = _self.getOwningClass().getName();
                  _builder_1.append(_name_3);
                  _builder_1.append(" self){");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t");
                  _builder_1.append("while(!(");
                  String _generate_1 = OCLExpressionAspect.generate(ifExp.getOwnedCondition(), context);
                  _builder_1.append(_generate_1, "\t");
                  _builder_1.append(")){");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t\t");
                  _builder_1.append("self=");
                  _builder_1.append(elseSource, "\t\t");
                  _builder_1.append(";");
                  _builder_1.newLineIfNotEmpty();
                  _builder_1.append("\t");
                  _builder_1.append("}");
                  _builder_1.newLine();
                  _builder_1.append("\t");
                  _builder_1.append("return self;");
                  _builder_1.newLine();
                  _builder_1.append("}");
                  _builder_1.newLine();
                  return _builder_1.toString();
                }
              }
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("public static ");
              String _name_4 = _self.getType().getName();
              _builder_2.append(_name_4);
              _builder_2.append(" ");
              String _name_5 = _self.getName();
              _builder_2.append(_name_5);
              _builder_2.append("( ");
              String _name_6 = _self.getOwningClass().getName();
              _builder_2.append(_name_6);
              _builder_2.append(" self){");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t");
              _builder_2.append("return \t");
              String _generate_2 = LanguageExpressionAspect.generate(_self.getBodyExpression(), context);
              _builder_2.append(_generate_2, "\t");
              _builder_2.append(";");
              _builder_2.newLineIfNotEmpty();
              _builder_2.append("\t");
              _builder_2.newLine();
              _builder_2.append("} ");
              _builder_2.newLine();
              _xblockexpression_1 = _builder_2.toString();
            }
            _switchResult = _xblockexpression_1;
            break;
        }
      } else {
        String _xblockexpression_1 = null;
        {
          context.getGlobalContext().getContextMethods().put(_self.getName(), _self.getOwningClass().getName());
          LanguageExpression _bodyExpression = _self.getBodyExpression();
          OCLExpression _ownedBody = ((ExpressionInOCL) _bodyExpression).getOwnedBody();
          if ((_ownedBody instanceof IfExp)) {
            LanguageExpression _bodyExpression_1 = _self.getBodyExpression();
            OCLExpression _ownedBody_1 = ((ExpressionInOCL) _bodyExpression_1).getOwnedBody();
            final IfExp ifExp = ((IfExp) _ownedBody_1);
            if (((ifExp.getOwnedElse() instanceof OperationCallExp) && ifExp.getOwnedElse().getName().equals(_self.getName()))) {
              OCLExpression _ownedElse = ifExp.getOwnedElse();
              final OperationCallExp ownedElse = ((OperationCallExp) _ownedElse);
              final String elseSource = OCLExpressionAspect.generate(ownedElse.getOwnedSource(), context);
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("public static ");
              String _name_1 = _self.getType().getName();
              _builder_1.append(_name_1);
              _builder_1.append(" ");
              String _name_2 = _self.getName();
              _builder_1.append(_name_2);
              _builder_1.append("( ");
              String _name_3 = _self.getOwningClass().getName();
              _builder_1.append(_name_3);
              _builder_1.append(" self){");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t");
              _builder_1.append("while(!(");
              String _generate_1 = OCLExpressionAspect.generate(ifExp.getOwnedCondition(), context);
              _builder_1.append(_generate_1, "\t");
              _builder_1.append(")){");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t\t");
              _builder_1.append("self=");
              _builder_1.append(elseSource, "\t\t");
              _builder_1.append(";");
              _builder_1.newLineIfNotEmpty();
              _builder_1.append("\t");
              _builder_1.append("}");
              _builder_1.newLine();
              _builder_1.append("\t");
              _builder_1.append("return self;");
              _builder_1.newLine();
              _builder_1.append("}");
              _builder_1.newLine();
              return _builder_1.toString();
            }
          }
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("public static ");
          String _name_4 = _self.getType().getName();
          _builder_2.append(_name_4);
          _builder_2.append(" ");
          String _name_5 = _self.getName();
          _builder_2.append(_name_5);
          _builder_2.append("( ");
          String _name_6 = _self.getOwningClass().getName();
          _builder_2.append(_name_6);
          _builder_2.append(" self){");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.append("return \t");
          String _generate_2 = LanguageExpressionAspect.generate(_self.getBodyExpression(), context);
          _builder_2.append(_generate_2, "\t");
          _builder_2.append(";");
          _builder_2.newLineIfNotEmpty();
          _builder_2.append("\t");
          _builder_2.newLine();
          _builder_2.append("} ");
          _builder_2.newLine();
          _xblockexpression_1 = _builder_2.toString();
        }
        _switchResult = _xblockexpression_1;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
