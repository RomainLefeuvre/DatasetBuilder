package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CollectionType;

@SuppressWarnings("all")
public class CollectionTypeAspectCollectionTypeAspectContext {
  public static final CollectionTypeAspectCollectionTypeAspectContext INSTANCE = new CollectionTypeAspectCollectionTypeAspectContext();
  
  public static CollectionTypeAspectCollectionTypeAspectProperties getSelf(final CollectionType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CollectionTypeAspectCollectionTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CollectionType, CollectionTypeAspectCollectionTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CollectionType, fr.inria.diverse.swhModel.generator.aspects.CollectionTypeAspectCollectionTypeAspectProperties>();
  
  public Map<CollectionType, CollectionTypeAspectCollectionTypeAspectProperties> getMap() {
    return map;
  }
}
