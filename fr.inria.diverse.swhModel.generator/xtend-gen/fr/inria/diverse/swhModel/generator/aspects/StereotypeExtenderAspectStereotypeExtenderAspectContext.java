package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.StereotypeExtender;

@SuppressWarnings("all")
public class StereotypeExtenderAspectStereotypeExtenderAspectContext {
  public static final StereotypeExtenderAspectStereotypeExtenderAspectContext INSTANCE = new StereotypeExtenderAspectStereotypeExtenderAspectContext();
  
  public static StereotypeExtenderAspectStereotypeExtenderAspectProperties getSelf(final StereotypeExtender _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.StereotypeExtenderAspectStereotypeExtenderAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StereotypeExtender, StereotypeExtenderAspectStereotypeExtenderAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.StereotypeExtender, fr.inria.diverse.swhModel.generator.aspects.StereotypeExtenderAspectStereotypeExtenderAspectProperties>();
  
  public Map<StereotypeExtender, StereotypeExtenderAspectStereotypeExtenderAspectProperties> getMap() {
    return map;
  }
}
