package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Slot;

@SuppressWarnings("all")
public class SlotAspectSlotAspectContext {
  public static final SlotAspectSlotAspectContext INSTANCE = new SlotAspectSlotAspectContext();
  
  public static SlotAspectSlotAspectProperties getSelf(final Slot _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SlotAspectSlotAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Slot, SlotAspectSlotAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Slot, fr.inria.diverse.swhModel.generator.aspects.SlotAspectSlotAspectProperties>();
  
  public Map<Slot, SlotAspectSlotAspectProperties> getMap() {
    return map;
  }
}
