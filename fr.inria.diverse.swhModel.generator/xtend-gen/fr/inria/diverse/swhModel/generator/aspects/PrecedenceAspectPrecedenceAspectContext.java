package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Precedence;

@SuppressWarnings("all")
public class PrecedenceAspectPrecedenceAspectContext {
  public static final PrecedenceAspectPrecedenceAspectContext INSTANCE = new PrecedenceAspectPrecedenceAspectContext();
  
  public static PrecedenceAspectPrecedenceAspectProperties getSelf(final Precedence _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.PrecedenceAspectPrecedenceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Precedence, PrecedenceAspectPrecedenceAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Precedence, fr.inria.diverse.swhModel.generator.aspects.PrecedenceAspectPrecedenceAspectProperties>();
  
  public Map<Precedence, PrecedenceAspectPrecedenceAspectProperties> getMap() {
    return map;
  }
}
