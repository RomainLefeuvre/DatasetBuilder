package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;

@SuppressWarnings("all")
public class ClassAspectClassAspectContext {
  public static final ClassAspectClassAspectContext INSTANCE = new ClassAspectClassAspectContext();
  
  public static ClassAspectClassAspectProperties getSelf(final org.eclipse.ocl.pivot.Class _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ClassAspectClassAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<org.eclipse.ocl.pivot.Class, ClassAspectClassAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Class, fr.inria.diverse.swhModel.generator.aspects.ClassAspectClassAspectProperties>();
  
  public Map<org.eclipse.ocl.pivot.Class, ClassAspectClassAspectProperties> getMap() {
    return map;
  }
}
