package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Pseudostate;

@SuppressWarnings("all")
public class PseudostateAspectPseudostateAspectContext {
  public static final PseudostateAspectPseudostateAspectContext INSTANCE = new PseudostateAspectPseudostateAspectContext();
  
  public static PseudostateAspectPseudostateAspectProperties getSelf(final Pseudostate _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PseudostateAspectPseudostateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Pseudostate, PseudostateAspectPseudostateAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Pseudostate, fr.inria.diverse.swhModel.generator.aspects.PseudostateAspectPseudostateAspectProperties>();
  
  public Map<Pseudostate, PseudostateAspectPseudostateAspectProperties> getMap() {
    return map;
  }
}
