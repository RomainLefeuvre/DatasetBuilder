package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.ValueSpecification;

@SuppressWarnings("all")
public class ValueSpecificationAspectValueSpecificationAspectContext {
  public static final ValueSpecificationAspectValueSpecificationAspectContext INSTANCE = new ValueSpecificationAspectValueSpecificationAspectContext();
  
  public static ValueSpecificationAspectValueSpecificationAspectProperties getSelf(final ValueSpecification _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ValueSpecificationAspectValueSpecificationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<ValueSpecification, ValueSpecificationAspectValueSpecificationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.ValueSpecification, fr.inria.diverse.swhModel.generator.aspects.ValueSpecificationAspectValueSpecificationAspectProperties>();
  
  public Map<ValueSpecification, ValueSpecificationAspectValueSpecificationAspectProperties> getMap() {
    return map;
  }
}
