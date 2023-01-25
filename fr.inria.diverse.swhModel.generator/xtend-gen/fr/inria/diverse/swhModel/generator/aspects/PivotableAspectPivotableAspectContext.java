package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.utilities.Pivotable;

@SuppressWarnings("all")
public class PivotableAspectPivotableAspectContext {
  public static final PivotableAspectPivotableAspectContext INSTANCE = new PivotableAspectPivotableAspectContext();
  
  public static PivotableAspectPivotableAspectProperties getSelf(final Pivotable _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PivotableAspectPivotableAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Pivotable, PivotableAspectPivotableAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.utilities.Pivotable, fr.inria.diverse.swhModel.generator.aspects.PivotableAspectPivotableAspectProperties>();
  
  public Map<Pivotable, PivotableAspectPivotableAspectProperties> getMap() {
    return map;
  }
}
