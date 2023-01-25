package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Type;

@SuppressWarnings("all")
public class TypeAspectTypeAspectContext {
  public static final TypeAspectTypeAspectContext INSTANCE = new TypeAspectTypeAspectContext();
  
  public static TypeAspectTypeAspectProperties getSelf(final Type _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TypeAspectTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Type, TypeAspectTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Type, fr.inria.diverse.swhModel.generator.aspects.TypeAspectTypeAspectProperties>();
  
  public Map<Type, TypeAspectTypeAspectProperties> getMap() {
    return map;
  }
}
