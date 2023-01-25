package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.DynamicValueSpecification;

@SuppressWarnings("all")
public class DynamicValueSpecificationAspectDynamicValueSpecificationAspectContext {
  public static final DynamicValueSpecificationAspectDynamicValueSpecificationAspectContext INSTANCE = new DynamicValueSpecificationAspectDynamicValueSpecificationAspectContext();
  
  public static DynamicValueSpecificationAspectDynamicValueSpecificationAspectProperties getSelf(final DynamicValueSpecification _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DynamicValueSpecificationAspectDynamicValueSpecificationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DynamicValueSpecification, DynamicValueSpecificationAspectDynamicValueSpecificationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.DynamicValueSpecification, fr.inria.diverse.swhModel.generator.aspects.DynamicValueSpecificationAspectDynamicValueSpecificationAspectProperties>();
  
  public Map<DynamicValueSpecification, DynamicValueSpecificationAspectDynamicValueSpecificationAspectProperties> getMap() {
    return map;
  }
}
