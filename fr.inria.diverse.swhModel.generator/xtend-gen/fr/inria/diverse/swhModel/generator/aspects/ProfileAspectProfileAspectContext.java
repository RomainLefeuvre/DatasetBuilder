package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Profile;

@SuppressWarnings("all")
public class ProfileAspectProfileAspectContext {
  public static final ProfileAspectProfileAspectContext INSTANCE = new ProfileAspectProfileAspectContext();
  
  public static ProfileAspectProfileAspectProperties getSelf(final Profile _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ProfileAspectProfileAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Profile, ProfileAspectProfileAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Profile, fr.inria.diverse.swhModel.generator.aspects.ProfileAspectProfileAspectProperties>();
  
  public Map<Profile, ProfileAspectProfileAspectProperties> getMap() {
    return map;
  }
}
