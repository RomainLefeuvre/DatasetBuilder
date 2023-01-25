package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.InstanceSpecification;

@SuppressWarnings("all")
public class InstanceSpecificationAspectInstanceSpecificationAspectContext {
  public static final InstanceSpecificationAspectInstanceSpecificationAspectContext INSTANCE = new InstanceSpecificationAspectInstanceSpecificationAspectContext();
  
  public static InstanceSpecificationAspectInstanceSpecificationAspectProperties getSelf(final InstanceSpecification _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.InstanceSpecificationAspectInstanceSpecificationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InstanceSpecification, InstanceSpecificationAspectInstanceSpecificationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.InstanceSpecification, fr.inria.diverse.swhModel.generator.aspects.InstanceSpecificationAspectInstanceSpecificationAspectProperties>();
  
  public Map<InstanceSpecification, InstanceSpecificationAspectInstanceSpecificationAspectProperties> getMap() {
    return map;
  }
}
