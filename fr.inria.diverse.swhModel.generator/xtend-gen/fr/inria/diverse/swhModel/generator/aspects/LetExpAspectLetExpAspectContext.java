package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.LetExp;

@SuppressWarnings("all")
public class LetExpAspectLetExpAspectContext {
  public static final LetExpAspectLetExpAspectContext INSTANCE = new LetExpAspectLetExpAspectContext();
  
  public static LetExpAspectLetExpAspectProperties getSelf(final LetExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LetExpAspectLetExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LetExp, LetExpAspectLetExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.LetExp, fr.inria.diverse.swhModel.generator.aspects.LetExpAspectLetExpAspectProperties>();
  
  public Map<LetExp, LetExpAspectLetExpAspectProperties> getMap() {
    return map;
  }
}
