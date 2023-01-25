package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.NullLiteralExp;

@SuppressWarnings("all")
public class NullLiteralExpAspectNullLiteralExpAspectContext {
  public static final NullLiteralExpAspectNullLiteralExpAspectContext INSTANCE = new NullLiteralExpAspectNullLiteralExpAspectContext();
  
  public static NullLiteralExpAspectNullLiteralExpAspectProperties getSelf(final NullLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NullLiteralExpAspectNullLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NullLiteralExp, NullLiteralExpAspectNullLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.NullLiteralExp, fr.inria.diverse.swhModel.generator.aspects.NullLiteralExpAspectNullLiteralExpAspectProperties>();
  
  public Map<NullLiteralExp, NullLiteralExpAspectNullLiteralExpAspectProperties> getMap() {
    return map;
  }
}
