package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.CollectionLiteralExp;

@SuppressWarnings("all")
public class CollectionLiteralExpAspectCollectionLiteralExpAspectContext {
  public static final CollectionLiteralExpAspectCollectionLiteralExpAspectContext INSTANCE = new CollectionLiteralExpAspectCollectionLiteralExpAspectContext();
  
  public static CollectionLiteralExpAspectCollectionLiteralExpAspectProperties getSelf(final CollectionLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.CollectionLiteralExpAspectCollectionLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<CollectionLiteralExp, CollectionLiteralExpAspectCollectionLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.CollectionLiteralExp, fr.inria.diverse.swhModel.generator.aspects.CollectionLiteralExpAspectCollectionLiteralExpAspectProperties>();
  
  public Map<CollectionLiteralExp, CollectionLiteralExpAspectCollectionLiteralExpAspectProperties> getMap() {
    return map;
  }
}
