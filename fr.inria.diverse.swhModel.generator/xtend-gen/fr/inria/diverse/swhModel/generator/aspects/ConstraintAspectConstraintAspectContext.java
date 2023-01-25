package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Constraint;

@SuppressWarnings("all")
public class ConstraintAspectConstraintAspectContext {
  public static final ConstraintAspectConstraintAspectContext INSTANCE = new ConstraintAspectConstraintAspectContext();
  
  public static ConstraintAspectConstraintAspectProperties getSelf(final Constraint _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ConstraintAspectConstraintAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Constraint, ConstraintAspectConstraintAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Constraint, fr.inria.diverse.swhModel.generator.aspects.ConstraintAspectConstraintAspectProperties>();
  
  public Map<Constraint, ConstraintAspectConstraintAspectProperties> getMap() {
    return map;
  }
}
