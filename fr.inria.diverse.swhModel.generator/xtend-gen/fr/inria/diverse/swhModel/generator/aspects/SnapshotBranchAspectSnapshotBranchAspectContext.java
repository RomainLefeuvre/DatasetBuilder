package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.SnapshotBranch;
import java.util.Map;

@SuppressWarnings("all")
public class SnapshotBranchAspectSnapshotBranchAspectContext {
  public static final SnapshotBranchAspectSnapshotBranchAspectContext INSTANCE = new SnapshotBranchAspectSnapshotBranchAspectContext();
  
  public static SnapshotBranchAspectSnapshotBranchAspectProperties getSelf(final SnapshotBranch _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SnapshotBranchAspectSnapshotBranchAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SnapshotBranch, SnapshotBranchAspectSnapshotBranchAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.SnapshotBranch, fr.inria.diverse.swhModel.generator.aspects.SnapshotBranchAspectSnapshotBranchAspectProperties>();
  
  public Map<SnapshotBranch, SnapshotBranchAspectSnapshotBranchAspectProperties> getMap() {
    return map;
  }
}
