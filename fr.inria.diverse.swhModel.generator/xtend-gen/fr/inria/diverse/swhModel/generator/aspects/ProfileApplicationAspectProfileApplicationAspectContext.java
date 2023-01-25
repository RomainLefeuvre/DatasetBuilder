package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ProfileApplication;

@SuppressWarnings("all")
public class ProfileApplicationAspectProfileApplicationAspectContext {
  public static final ProfileApplicationAspectProfileApplicationAspectContext INSTANCE = new ProfileApplicationAspectProfileApplicationAspectContext();
  
  public static ProfileApplicationAspectProfileApplicationAspectProperties getSelf(final ProfileApplication _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ProfileApplicationAspectProfileApplicationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ProfileApplication, ProfileApplicationAspectProfileApplicationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ProfileApplication, fr.inria.diverse.swhModel.generator.aspects.ProfileApplicationAspectProfileApplicationAspectProperties>();
  
  public Map<ProfileApplication, ProfileApplicationAspectProfileApplicationAspectProperties> getMap() {
    return map;
  }
}
