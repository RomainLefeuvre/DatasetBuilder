package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.SnapshotChild;
import java.util.Map;

@SuppressWarnings("all")
public class SnapshotChildAspectSnapshotChildAspectContext {
  public static final SnapshotChildAspectSnapshotChildAspectContext INSTANCE = new SnapshotChildAspectSnapshotChildAspectContext();
  
  public static SnapshotChildAspectSnapshotChildAspectProperties getSelf(final SnapshotChild _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SnapshotChildAspectSnapshotChildAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SnapshotChild, SnapshotChildAspectSnapshotChildAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.SnapshotChild, fr.inria.diverse.swhModel.generator.aspects.SnapshotChildAspectSnapshotChildAspectProperties>();
  
  public Map<SnapshotChild, SnapshotChildAspectSnapshotChildAspectProperties> getMap() {
    return map;
  }
}
