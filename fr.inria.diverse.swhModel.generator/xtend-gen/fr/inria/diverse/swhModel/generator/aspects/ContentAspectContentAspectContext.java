package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Content;
import java.util.Map;

@SuppressWarnings("all")
public class ContentAspectContentAspectContext {
  public static final ContentAspectContentAspectContext INSTANCE = new ContentAspectContentAspectContext();
  
  public static ContentAspectContentAspectProperties getSelf(final Content _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ContentAspectContentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Content, ContentAspectContentAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Content, fr.inria.diverse.swhModel.generator.aspects.ContentAspectContentAspectProperties>();
  
  public Map<Content, ContentAspectContentAspectProperties> getMap() {
    return map;
  }
}
