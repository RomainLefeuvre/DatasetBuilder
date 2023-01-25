package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Release;
import java.util.Map;

@SuppressWarnings("all")
public class ReleaseAspectReleaseAspectContext {
  public static final ReleaseAspectReleaseAspectContext INSTANCE = new ReleaseAspectReleaseAspectContext();
  
  public static ReleaseAspectReleaseAspectProperties getSelf(final Release _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ReleaseAspectReleaseAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Release, ReleaseAspectReleaseAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Release, fr.inria.diverse.swhModel.generator.aspects.ReleaseAspectReleaseAspectProperties>();
  
  public Map<Release, ReleaseAspectReleaseAspectProperties> getMap() {
    return map;
  }
}
