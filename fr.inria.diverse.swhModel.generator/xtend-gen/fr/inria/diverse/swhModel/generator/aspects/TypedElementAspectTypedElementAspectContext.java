package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TypedElement;

@SuppressWarnings("all")
public class TypedElementAspectTypedElementAspectContext {
  public static final TypedElementAspectTypedElementAspectContext INSTANCE = new TypedElementAspectTypedElementAspectContext();
  
  public static TypedElementAspectTypedElementAspectProperties getSelf(final TypedElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TypedElementAspectTypedElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TypedElement, TypedElementAspectTypedElementAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TypedElement, fr.inria.diverse.swhModel.generator.aspects.TypedElementAspectTypedElementAspectProperties>();
  
  public Map<TypedElement, TypedElementAspectTypedElementAspectProperties> getMap() {
    return map;
  }
}
