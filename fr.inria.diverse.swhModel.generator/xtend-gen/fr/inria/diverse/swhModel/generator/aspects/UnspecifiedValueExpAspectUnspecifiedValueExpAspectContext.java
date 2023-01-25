package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.UnspecifiedValueExp;

@SuppressWarnings("all")
public class UnspecifiedValueExpAspectUnspecifiedValueExpAspectContext {
  public static final UnspecifiedValueExpAspectUnspecifiedValueExpAspectContext INSTANCE = new UnspecifiedValueExpAspectUnspecifiedValueExpAspectContext();
  
  public static UnspecifiedValueExpAspectUnspecifiedValueExpAspectProperties getSelf(final UnspecifiedValueExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.UnspecifiedValueExpAspectUnspecifiedValueExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<UnspecifiedValueExp, UnspecifiedValueExpAspectUnspecifiedValueExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.UnspecifiedValueExp, fr.inria.diverse.swhModel.generator.aspects.UnspecifiedValueExpAspectUnspecifiedValueExpAspectProperties>();
  
  public Map<UnspecifiedValueExp, UnspecifiedValueExpAspectUnspecifiedValueExpAspectProperties> getMap() {
    return map;
  }
}
