package fr.inria.diverse.swhModel.generator.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = IteratorExp.class)
@SuppressWarnings("all")
public class IteratorExpAspect extends LoopExpAspect {
  public static String generate(final IteratorExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspectIteratorExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspectIteratorExpAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.IteratorExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.IteratorExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final IteratorExpAspectIteratorExpAspectProperties _self_, final IteratorExp _self, final Context context) {
    String _xblockexpression = null;
    {
      final Context c = context.clone();
      final String propertyToSearchIn = OCLExpressionAspect.generate(_self.getOwnedSource(), context);
      String iteratorVariable = _self.getOwnedIterators().get(0).getName();
      boolean _equals = iteratorVariable.equals("1_");
      if (_equals) {
        String source = _self.getOwnedSource().getName();
        String _xifexpression = null;
        if (((!Objects.equal(source, null)) && (!source.equals("oclAsSet")))) {
          int _length = source.length();
          int _minus = (_length - 1);
          _xifexpression = source.substring(0, _minus);
        } else {
          int _nextVar = context.getGlobalContext().getNextVar();
          _xifexpression = ("var_" + Integer.valueOf(_nextVar));
        }
        iteratorVariable = _xifexpression;
      }
      c.setIteratorVariable(iteratorVariable);
      String _switchResult = null;
      String _name = _self.getName();
      if (_name != null) {
        switch (_name) {
          case "select":
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("List<Long> selectResult = new LambdaExplorer<Long, Long>(g, ");
            _builder.append(propertyToSearchIn);
            _builder.append(",id) {");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            _builder.append("@Override");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("public void exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {");
            _builder.newLine();
            _builder.append("\t    ");
            _builder.append("Origin ");
            _builder.append(iteratorVariable, "\t    ");
            _builder.append(" = new Origin(currentElement, graphCopy);");
            _builder.newLineIfNotEmpty();
            _builder.append("\t    ");
            _builder.append("boolean predicateResult = ");
            String _generate = OCLExpressionAspect.generate(_self.getOwnedBody(), c);
            _builder.append(_generate, "\t    ");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t    ");
            _builder.append("if (predicateResult) {");
            _builder.newLine();
            _builder.append("\t    \t");
            _builder.append("result.add(currentElement);");
            _builder.newLine();
            _builder.append("\t    ");
            _builder.append("}");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("}.explore();");
            _builder.newLine();
            _builder.append("results.addAll(selectResult);");
            _builder.newLine();
            _switchResult = _builder.toString();
            break;
          case "exists":
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(propertyToSearchIn);
            _builder_1.append(".stream().anyMatch(");
            _builder_1.append(iteratorVariable);
            _builder_1.append(" ->");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t");
            String _generate_1 = OCLExpressionAspect.generate(_self.getOwnedBody(), c);
            _builder_1.append(_generate_1, "\t");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append(")");
            _switchResult = _builder_1.toString();
            break;
          case "forAll":
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(propertyToSearchIn);
            _builder_2.append(".stream().allMatch(");
            _builder_2.append(iteratorVariable);
            _builder_2.append(" ->");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append("\t");
            String _generate_2 = OCLExpressionAspect.generate(_self.getOwnedBody(), c);
            _builder_2.append(_generate_2, "\t");
            _builder_2.newLineIfNotEmpty();
            _builder_2.append(")");
            _switchResult = _builder_2.toString();
            break;
          case "sortedBy":
            _switchResult = OCLExpressionAspect.generate(_self.getOwnedSource(), context);
            break;
          case "closure":
            String _xblockexpression_1 = null;
            {
              final String type = _self.getOwnedIterators().get(0).getType().getName();
              int _nextVar_1 = context.getGlobalContext().getNextVar();
              final String closureStaticFunctionName = ((type + "Closure") + Integer.valueOf(_nextVar_1));
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.newLine();
              _builder_3.append(" ");
              _builder_3.append("public static Set<");
              _builder_3.append(type, " ");
              _builder_3.append("> ");
              _builder_3.append(closureStaticFunctionName, " ");
              _builder_3.append("(Set<");
              _builder_3.append(type, " ");
              _builder_3.append("> param ){");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append(" \t\t");
              _builder_3.append("Stack<");
              _builder_3.append(type, " \t\t");
              _builder_3.append("> stack = new Stack<>();");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append(" \t\t");
              _builder_3.append("HashSet<");
              _builder_3.append(type, " \t\t");
              _builder_3.append("> res = new HashSet<>();");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append(" \t\t");
              _builder_3.append("stack.addAll(param);");
              _builder_3.newLine();
              _builder_3.append(" \t\t");
              _builder_3.append("res.addAll(param);");
              _builder_3.newLine();
              _builder_3.append(" \t\t");
              _builder_3.newLine();
              _builder_3.append(" \t\t");
              _builder_3.append("while(!stack.isEmpty()){");
              _builder_3.newLine();
              _builder_3.append(" \t\t\t        ");
              _builder_3.append("Set<");
              _builder_3.append(type, " \t\t\t        ");
              _builder_3.append("> children= new HashSet<");
              _builder_3.append(type, " \t\t\t        ");
              _builder_3.append(">();");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append(" \t\t\t\t\t");
              _builder_3.newLine();
              _builder_3.append(" \t\t            ");
              _builder_3.append(type, " \t\t            ");
              _builder_3.append(" ");
              String _iteratorVariable = c.getIteratorVariable();
              _builder_3.append(_iteratorVariable, " \t\t            ");
              _builder_3.append("=stack.pop();");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append(" \t\t            ");
              _builder_3.append("try{");
              _builder_3.newLine();
              {
                Type _type = _self.getOwnedBody().getType();
                boolean _not = (!(_type instanceof CollectionType));
                if (_not) {
                  _builder_3.append(" \t\t            ");
                  _builder_3.append("children= new HashSet<");
                  _builder_3.append(type, " \t\t            ");
                  _builder_3.append(">(Arrays.asList(");
                  String _generate_3 = OCLExpressionAspect.generate(_self.getOwnedBody(), c);
                  _builder_3.append(_generate_3, " \t\t            ");
                  _builder_3.append("));");
                  _builder_3.newLineIfNotEmpty();
                } else {
                  _builder_3.append(" \t\t            ");
                  _builder_3.append("children= ");
                  String _generate_4 = OCLExpressionAspect.generate(_self.getOwnedBody(), c);
                  _builder_3.append(_generate_4, " \t\t            ");
                  _builder_3.append(";\t\t \t\t            ");
                  _builder_3.newLineIfNotEmpty();
                }
              }
              _builder_3.append(" \t\t            ");
              _builder_3.append("}catch(Exception e){");
              _builder_3.newLine();
              _builder_3.append(" \t\t            \t");
              _builder_3.append("logger.warn(\"Error during closure for\"+ param);");
              _builder_3.newLine();
              _builder_3.append(" \t\t           \t\t");
              _builder_3.append("logger.debug(\"Error during closure for\"+ param,e);");
              _builder_3.newLine();
              _builder_3.append(" \t\t            ");
              _builder_3.append("}");
              _builder_3.newLine();
              _builder_3.append(" \t\t            ");
              _builder_3.append("for(");
              _builder_3.append(type, " \t\t            ");
              _builder_3.append(" child: children){");
              _builder_3.newLineIfNotEmpty();
              _builder_3.append(" \t\t                ");
              _builder_3.append("if(child!=null && !res.contains(child)){");
              _builder_3.newLine();
              _builder_3.append(" \t\t                    ");
              _builder_3.append("res.add(child);");
              _builder_3.newLine();
              _builder_3.append(" \t\t                    ");
              _builder_3.append("stack.add(child);");
              _builder_3.newLine();
              _builder_3.append(" \t\t                ");
              _builder_3.append("}");
              _builder_3.newLine();
              _builder_3.append(" \t\t            ");
              _builder_3.append("}");
              _builder_3.newLine();
              _builder_3.append(" \t\t");
              _builder_3.newLine();
              _builder_3.append(" \t\t        ");
              _builder_3.append("}");
              _builder_3.newLine();
              _builder_3.append(" \t\t        ");
              _builder_3.append("return res;");
              _builder_3.newLine();
              _builder_3.append(" \t\t ");
              _builder_3.append("}");
              _builder_3.newLine();
              context.getGlobalContext().getStaticMethods().putIfAbsent(closureStaticFunctionName, _builder_3.toString());
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append(closureStaticFunctionName);
              _builder_4.append("(");
              _builder_4.append(propertyToSearchIn);
              _builder_4.append(".stream().collect(Collectors.toSet()))");
              _builder_4.newLineIfNotEmpty();
              _xblockexpression_1 = _builder_4.toString();
            }
            _switchResult = _xblockexpression_1;
            break;
          case "collect":
            String _xifexpression_1 = null;
            if (((_self.getOwnedSource().getType() instanceof CollectionType) && Objects.equal(_self.getOwnedBody().getName(), "oclAsSet"))) {
              StringConcatenation _builder_3 = new StringConcatenation();
              String _generate_3 = OCLExpressionAspect.generate(_self.getOwnedSource(), context);
              _builder_3.append(_generate_3);
              _builder_3.append(".stream().collect(Collectors.toSet())");
              _builder_3.newLineIfNotEmpty();
              _xifexpression_1 = _builder_3.toString();
            }
            _switchResult = _xifexpression_1;
            break;
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
