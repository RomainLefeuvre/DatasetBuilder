package fr.inria.diverse.swhModel.generator.aspects;

import java.util.HashMap;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class GlobalContext {
  private HashMap<String, String> staticMethods;
  
  private HashMap<String, String> contextMethods;
  
  private int varIndex;
  
  public GlobalContext() {
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    this.staticMethods = _hashMap;
    HashMap<String, String> _hashMap_1 = new HashMap<String, String>();
    this.contextMethods = _hashMap_1;
    this.varIndex = 0;
  }
  
  public int getNextVar() {
    int _xblockexpression = (int) 0;
    {
      this.varIndex++;
      _xblockexpression = this.varIndex;
    }
    return _xblockexpression;
  }
  
  @Pure
  public HashMap<String, String> getStaticMethods() {
    return this.staticMethods;
  }
  
  public void setStaticMethods(final HashMap<String, String> staticMethods) {
    this.staticMethods = staticMethods;
  }
  
  @Pure
  public HashMap<String, String> getContextMethods() {
    return this.contextMethods;
  }
  
  public void setContextMethods(final HashMap<String, String> contextMethods) {
    this.contextMethods = contextMethods;
  }
  
  @Pure
  public int getVarIndex() {
    return this.varIndex;
  }
  
  public void setVarIndex(final int varIndex) {
    this.varIndex = varIndex;
  }
}
