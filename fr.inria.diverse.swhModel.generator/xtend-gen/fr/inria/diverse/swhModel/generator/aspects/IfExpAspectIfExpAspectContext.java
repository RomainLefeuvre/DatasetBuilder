package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.IfExp;

@SuppressWarnings("all")
public class IfExpAspectIfExpAspectContext {
  public static final IfExpAspectIfExpAspectContext INSTANCE = new IfExpAspectIfExpAspectContext();
  
  public static IfExpAspectIfExpAspectProperties getSelf(final IfExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.IfExpAspectIfExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<IfExp, IfExpAspectIfExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.IfExp, fr.inria.diverse.swhModel.generator.aspects.IfExpAspectIfExpAspectProperties>();
  
  public Map<IfExp, IfExpAspectIfExpAspectProperties> getMap() {
    return map;
  }
}
