package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.SetType;

@SuppressWarnings("all")
public class SetTypeAspectSetTypeAspectContext {
  public static final SetTypeAspectSetTypeAspectContext INSTANCE = new SetTypeAspectSetTypeAspectContext();
  
  public static SetTypeAspectSetTypeAspectProperties getSelf(final SetType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SetTypeAspectSetTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SetType, SetTypeAspectSetTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.SetType, fr.inria.diverse.swhModel.generator.aspects.SetTypeAspectSetTypeAspectProperties>();
  
  public Map<SetType, SetTypeAspectSetTypeAspectProperties> getMap() {
    return map;
  }
}
