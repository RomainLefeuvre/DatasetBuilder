package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CollectionItem;

@SuppressWarnings("all")
public class CollectionItemAspectCollectionItemAspectContext {
  public static final CollectionItemAspectCollectionItemAspectContext INSTANCE = new CollectionItemAspectCollectionItemAspectContext();
  
  public static CollectionItemAspectCollectionItemAspectProperties getSelf(final CollectionItem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CollectionItemAspectCollectionItemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CollectionItem, CollectionItemAspectCollectionItemAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CollectionItem, fr.inria.diverse.swhModel.generator.aspects.CollectionItemAspectCollectionItemAspectProperties>();
  
  public Map<CollectionItem, CollectionItemAspectCollectionItemAspectProperties> getMap() {
    return map;
  }
}
