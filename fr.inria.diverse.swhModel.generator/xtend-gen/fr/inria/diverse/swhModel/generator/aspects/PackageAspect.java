package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Collection;
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
    String _xblockexpression = null;
    {
      final Context c = new Context();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package fr.inria.diverse.query;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.*;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.model.*;");
      _builder.newLine();
      _builder.append("import fr.inria.diverse.tools.*;");
      _builder.newLine();
      _builder.append("import org.apache.logging.log4j.LogManager;");
      _builder.newLine();
      _builder.append("import org.apache.logging.log4j.Logger;");
      _builder.newLine();
      _builder.append("import org.softwareheritage.graph.SwhType;");
      _builder.newLine();
      _builder.append("import org.softwareheritage.graph.SwhUnidirectionalGraph;");
      _builder.newLine();
      _builder.append("import java.io.IOException;");
      _builder.newLine();
      _builder.append("import java.util.stream.Collectors;");
      _builder.newLine();
      _builder.append("import java.util.*;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class GraphQuery implements IGraphQuery{");
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
      _builder.append("public GraphQuery(Graph g) throws IOException {");
      _builder.newLine();
      _builder.append("    \t\t");
      _builder.append("this.g = g;");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      {
        List<org.eclipse.ocl.pivot.Class> _ownedClasses = _self.getOwnedClasses();
        for(final org.eclipse.ocl.pivot.Class ownedClass : _ownedClasses) {
          {
            boolean _equals = ownedClass.getName().equals("Graph");
            boolean _not = (!_equals);
            if (_not) {
              _builder.append("\t");
              String _generate = ClassAspect.generate(ownedClass, c);
              _builder.append(_generate, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        List<org.eclipse.ocl.pivot.Class> _ownedClasses_1 = _self.getOwnedClasses();
        for(final org.eclipse.ocl.pivot.Class ownedClass_1 : _ownedClasses_1) {
          {
            boolean _equals_1 = ownedClass_1.getName().equals("Graph");
            if (_equals_1) {
              _builder.append("\t");
              String _generate_1 = ClassAspect.generate(ownedClass_1, c);
              _builder.append(_generate_1, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      {
        Collection<String> _values = c.getGlobalContext().getStaticMethods().values();
        for(final String staticMethod : _values) {
          _builder.append("\t");
          _builder.append(staticMethod, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
}
