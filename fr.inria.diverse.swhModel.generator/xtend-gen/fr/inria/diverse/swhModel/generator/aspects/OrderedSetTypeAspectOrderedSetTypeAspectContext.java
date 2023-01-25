package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.OrderedSetType;

@SuppressWarnings("all")
public class OrderedSetTypeAspectOrderedSetTypeAspectContext {
  public static final OrderedSetTypeAspectOrderedSetTypeAspectContext INSTANCE = new OrderedSetTypeAspectOrderedSetTypeAspectContext();
  
  public static OrderedSetTypeAspectOrderedSetTypeAspectProperties getSelf(final OrderedSetType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.OrderedSetTypeAspectOrderedSetTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OrderedSetType, OrderedSetTypeAspectOrderedSetTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.OrderedSetType, fr.inria.diverse.swhModel.generator.aspects.OrderedSetTypeAspectOrderedSetTypeAspectProperties>();
  
  public Map<OrderedSetType, OrderedSetTypeAspectOrderedSetTypeAspectProperties> getMap() {
    return map;
  }
}
