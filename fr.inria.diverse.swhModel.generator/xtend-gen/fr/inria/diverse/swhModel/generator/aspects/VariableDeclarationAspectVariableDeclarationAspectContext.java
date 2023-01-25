package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.VariableDeclaration;

@SuppressWarnings("all")
public class VariableDeclarationAspectVariableDeclarationAspectContext {
  public static final VariableDeclarationAspectVariableDeclarationAspectContext INSTANCE = new VariableDeclarationAspectVariableDeclarationAspectContext();
  
  public static VariableDeclarationAspectVariableDeclarationAspectProperties getSelf(final VariableDeclaration _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.VariableDeclarationAspectVariableDeclarationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<VariableDeclaration, VariableDeclarationAspectVariableDeclarationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.VariableDeclaration, fr.inria.diverse.swhModel.generator.aspects.VariableDeclarationAspectVariableDeclarationAspectProperties>();
  
  public Map<VariableDeclaration, VariableDeclarationAspectVariableDeclarationAspectProperties> getMap() {
    return map;
  }
}
