package fr.inria.diverse.swhModel.generator.aspects;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Context {
  private String returnVariable;
  
  private String returnType;
  
  private String indent;
  
  private String iteratorVariable;
  
  private GlobalContext globalContext;
  
  public Context(final String indent) {
    this.indent = indent;
  }
  
  public Context() {
    this.indent = "";
    GlobalContext _globalContext = new GlobalContext();
    this.globalContext = _globalContext;
  }
  
  public Context addIndentAndCopy(final String indentToAdd) {
    final Context result = new Context((this.indent + indentToAdd));
    result.iteratorVariable = this.iteratorVariable;
    return result;
  }
  
  /**
   * Clone all attribute except static methods
   */
  @Override
  public Context clone() {
    final Context context = new Context(this.indent);
    context.iteratorVariable = this.iteratorVariable;
    context.globalContext = this.globalContext;
    context.returnType = this.returnType;
    context.returnVariable = this.returnVariable;
    return context;
  }
  
  @Pure
  public String getReturnVariable() {
    return this.returnVariable;
  }
  
  public void setReturnVariable(final String returnVariable) {
    this.returnVariable = returnVariable;
  }
  
  @Pure
  public String getReturnType() {
    return this.returnType;
  }
  
  public void setReturnType(final String returnType) {
    this.returnType = returnType;
  }
  
  @Pure
  public String getIndent() {
    return this.indent;
  }
  
  public void setIndent(final String indent) {
    this.indent = indent;
  }
  
  @Pure
  public String getIteratorVariable() {
    return this.iteratorVariable;
  }
  
  public void setIteratorVariable(final String iteratorVariable) {
    this.iteratorVariable = iteratorVariable;
  }
  
  @Pure
  public GlobalContext getGlobalContext() {
    return this.globalContext;
  }
  
  public void setGlobalContext(final GlobalContext globalContext) {
    this.globalContext = globalContext;
  }
}
