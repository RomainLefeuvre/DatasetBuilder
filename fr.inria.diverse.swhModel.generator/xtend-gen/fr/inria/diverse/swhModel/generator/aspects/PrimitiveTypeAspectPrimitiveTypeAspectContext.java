package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.PrimitiveType;

@SuppressWarnings("all")
public class PrimitiveTypeAspectPrimitiveTypeAspectContext {
  public static final PrimitiveTypeAspectPrimitiveTypeAspectContext INSTANCE = new PrimitiveTypeAspectPrimitiveTypeAspectContext();
  
  public static PrimitiveTypeAspectPrimitiveTypeAspectProperties getSelf(final PrimitiveType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PrimitiveTypeAspectPrimitiveTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<PrimitiveType, PrimitiveTypeAspectPrimitiveTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.PrimitiveType, fr.inria.diverse.swhModel.generator.aspects.PrimitiveTypeAspectPrimitiveTypeAspectProperties>();
  
  public Map<PrimitiveType, PrimitiveTypeAspectPrimitiveTypeAspectProperties> getMap() {
    return map;
  }
}
