package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CollectionLiteralPart;

@SuppressWarnings("all")
public class CollectionLiteralPartAspectCollectionLiteralPartAspectContext {
  public static final CollectionLiteralPartAspectCollectionLiteralPartAspectContext INSTANCE = new CollectionLiteralPartAspectCollectionLiteralPartAspectContext();
  
  public static CollectionLiteralPartAspectCollectionLiteralPartAspectProperties getSelf(final CollectionLiteralPart _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CollectionLiteralPartAspectCollectionLiteralPartAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CollectionLiteralPart, CollectionLiteralPartAspectCollectionLiteralPartAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CollectionLiteralPart, fr.inria.diverse.swhModel.generator.aspects.CollectionLiteralPartAspectCollectionLiteralPartAspectProperties>();
  
  public Map<CollectionLiteralPart, CollectionLiteralPartAspectCollectionLiteralPartAspectProperties> getMap() {
    return map;
  }
}
