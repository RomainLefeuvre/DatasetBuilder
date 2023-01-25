package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Collection;
import java.util.List;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.xtend2.lib.StringConcatenation;

@Aspect(className = org.eclipse.ocl.pivot.Class.class)
@SuppressWarnings("all")
public class ClassAspect extends TypeAspect {
  /**
   * BE CAREFUL :
   * 
   * This class has more than one superclass
   * please specify which parent you want with the 'super' expected calling
   */
  public static String generate(final org.eclipse.ocl.pivot.Class _self, final String queryId) {
    final fr.inria.diverse.swhModel.generator.aspects.ClassAspectClassAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.ClassAspectClassAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# String generate(String)
    if (_self instanceof org.eclipse.ocl.pivot.Class){
    	result = fr.inria.diverse.swhModel.generator.aspects.ClassAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.Class)_self,queryId);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final ClassAspectClassAspectProperties _self_, final org.eclipse.ocl.pivot.Class _self, final String queryId) {
    String _xblockexpression = null;
    {
      final Context c = new Context();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package fr.inria.diverse;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.Graph;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.LambdaExplorer;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.model.Origin;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.tools.Configuration;");
      _builder.newLine();
      _builder.append("import org.apache.logging.log4j.LogManager;");
      _builder.newLine();
      _builder.append("import org.apache.logging.log4j.Logger;");
      _builder.newLine();
      _builder.append("import org.softwareheritage.graph.SwhType;");
      _builder.newLine();
      _builder.append("import org.softwareheritage.graph.SwhUnidirectionalGraph;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.tools.ToolBox;");
      _builder.newLine();
      _builder.append("import java.io.IOException;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.model.*;");
      _builder.newLine();
      _builder.append("import java.util.stream.Collectors;");
      _builder.newLine();
      _builder.append("import java.util.*;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class GraphQuery {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("static Logger logger = LogManager.getLogger(GraphQuery.class);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("static String id = \"");
      _builder.append(queryId, "    ");
      _builder.append("\";");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("private Graph g;\t\t    ");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public GraphQuery() throws IOException {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("g = new Graph();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("g.loadGraph();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.newLine();
      {
        List<Operation> _ownedOperations = _self.getOwnedOperations();
        for(final Operation operation : _ownedOperations) {
          String _generate = OperationAspect.generate(operation, c);
          _builder.append(_generate);
          _builder.newLineIfNotEmpty();
        }
      }
      {
        Collection<String> _values = c.getGlobalContext().getStaticMethods().values();
        for(final String staticMethod : _values) {
          _builder.append(staticMethod);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public static void main(String[] args) throws IOException, InterruptedException {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("Configuration.init();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("Set<Long> queryResult = new GraphQuery().runQuery();");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("ToolBox.exportObjectToJson(queryResult, Configuration.getInstance().getExportPath() + \"/query/results\");");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
