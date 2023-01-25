package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TypeExp;

@SuppressWarnings("all")
public class TypeExpAspectTypeExpAspectContext {
  public static final TypeExpAspectTypeExpAspectContext INSTANCE = new TypeExpAspectTypeExpAspectContext();
  
  public static TypeExpAspectTypeExpAspectProperties getSelf(final TypeExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TypeExpAspectTypeExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TypeExp, TypeExpAspectTypeExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TypeExp, fr.inria.diverse.swhModel.generator.aspects.TypeExpAspectTypeExpAspectProperties>();
  
  public Map<TypeExp, TypeExpAspectTypeExpAspectProperties> getMap() {
    return map;
  }
}
