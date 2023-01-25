package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Snapshot;
import java.util.Map;

@SuppressWarnings("all")
public class SnapshotAspectSnapshotAspectContext {
  public static final SnapshotAspectSnapshotAspectContext INSTANCE = new SnapshotAspectSnapshotAspectContext();
  
  public static SnapshotAspectSnapshotAspectProperties getSelf(final Snapshot _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SnapshotAspectSnapshotAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Snapshot, SnapshotAspectSnapshotAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Snapshot, fr.inria.diverse.swhModel.generator.aspects.SnapshotAspectSnapshotAspectProperties>();
  
  public Map<Snapshot, SnapshotAspectSnapshotAspectProperties> getMap() {
    return map;
  }
}
