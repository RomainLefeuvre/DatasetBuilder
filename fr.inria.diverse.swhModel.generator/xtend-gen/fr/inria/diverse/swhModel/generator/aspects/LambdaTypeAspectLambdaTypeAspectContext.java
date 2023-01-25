package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.LambdaType;

@SuppressWarnings("all")
public class LambdaTypeAspectLambdaTypeAspectContext {
  public static final LambdaTypeAspectLambdaTypeAspectContext INSTANCE = new LambdaTypeAspectLambdaTypeAspectContext();
  
  public static LambdaTypeAspectLambdaTypeAspectProperties getSelf(final LambdaType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LambdaTypeAspectLambdaTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<LambdaType, LambdaTypeAspectLambdaTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.LambdaType, fr.inria.diverse.swhModel.generator.aspects.LambdaTypeAspectLambdaTypeAspectProperties>();
  
  public Map<LambdaType, LambdaTypeAspectLambdaTypeAspectProperties> getMap() {
    return map;
  }
}
