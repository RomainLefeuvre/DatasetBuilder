package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.utilities.MorePivotable;

@SuppressWarnings("all")
public class MorePivotableAspectMorePivotableAspectContext {
  public static final MorePivotableAspectMorePivotableAspectContext INSTANCE = new MorePivotableAspectMorePivotableAspectContext();
  
  public static MorePivotableAspectMorePivotableAspectProperties getSelf(final MorePivotable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.MorePivotableAspectMorePivotableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<MorePivotable, MorePivotableAspectMorePivotableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.utilities.MorePivotable, fr.inria.diverse.swhModel.generator.aspects.MorePivotableAspectMorePivotableAspectProperties>();
  
  public Map<MorePivotable, MorePivotableAspectMorePivotableAspectProperties> getMap() {
    return map;
  }
}
