package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@Aspect(className = Operation.class)
@SuppressWarnings("all")
public class OperationAspect extends FeatureAspect {
  /**
   * BE CAREFUL :
   * 
   * This class has more than one superclass
   * please specify which parent you want with the 'super' expected calling
   */
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
    String _switchResult = null;
    String _name = _self.getName();
    if (_name != null) {
      switch (_name) {
        case "query":
          String _xblockexpression = null;
          {
            EObject _get = _self.eContents().get(0);
            final ExpressionInOCL expr = ((ExpressionInOCL) _get);
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
            String _generate = ExpressionInOCLAspect.generate(expr, context);
            _builder.append(_generate, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("return results;\t\t\t    ");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            _xblockexpression = _builder.toString();
          }
          _switchResult = _xblockexpression;
          break;
        default:
          _switchResult = InputOutput.<String>print("Not a query");
          break;
      }
    } else {
      _switchResult = InputOutput.<String>print("Not a query");
    }
    return _switchResult;
  }
}
