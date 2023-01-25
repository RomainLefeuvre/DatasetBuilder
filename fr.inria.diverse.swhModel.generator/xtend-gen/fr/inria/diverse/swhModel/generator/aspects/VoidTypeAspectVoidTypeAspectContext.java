package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.VoidType;

@SuppressWarnings("all")
public class VoidTypeAspectVoidTypeAspectContext {
  public static final VoidTypeAspectVoidTypeAspectContext INSTANCE = new VoidTypeAspectVoidTypeAspectContext();
  
  public static VoidTypeAspectVoidTypeAspectProperties getSelf(final VoidType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.VoidTypeAspectVoidTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<VoidType, VoidTypeAspectVoidTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.VoidType, fr.inria.diverse.swhModel.generator.aspects.VoidTypeAspectVoidTypeAspectProperties>();
  
  public Map<VoidType, VoidTypeAspectVoidTypeAspectProperties> getMap() {
    return map;
  }
}
