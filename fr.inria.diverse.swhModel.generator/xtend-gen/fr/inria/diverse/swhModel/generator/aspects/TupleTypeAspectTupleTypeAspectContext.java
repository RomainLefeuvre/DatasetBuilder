package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TupleType;

@SuppressWarnings("all")
public class TupleTypeAspectTupleTypeAspectContext {
  public static final TupleTypeAspectTupleTypeAspectContext INSTANCE = new TupleTypeAspectTupleTypeAspectContext();
  
  public static TupleTypeAspectTupleTypeAspectProperties getSelf(final TupleType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TupleTypeAspectTupleTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TupleType, TupleTypeAspectTupleTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TupleType, fr.inria.diverse.swhModel.generator.aspects.TupleTypeAspectTupleTypeAspectProperties>();
  
  public Map<TupleType, TupleTypeAspectTupleTypeAspectProperties> getMap() {
    return map;
  }
}
