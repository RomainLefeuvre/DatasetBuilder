package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CollectionRange;

@SuppressWarnings("all")
public class CollectionRangeAspectCollectionRangeAspectContext {
  public static final CollectionRangeAspectCollectionRangeAspectContext INSTANCE = new CollectionRangeAspectCollectionRangeAspectContext();
  
  public static CollectionRangeAspectCollectionRangeAspectProperties getSelf(final CollectionRange _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CollectionRangeAspectCollectionRangeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CollectionRange, CollectionRangeAspectCollectionRangeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CollectionRange, fr.inria.diverse.swhModel.generator.aspects.CollectionRangeAspectCollectionRangeAspectProperties>();
  
  public Map<CollectionRange, CollectionRangeAspectCollectionRangeAspectProperties> getMap() {
    return map;
  }
}
