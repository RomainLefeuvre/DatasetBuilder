package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.InvalidLiteralExp;

@SuppressWarnings("all")
public class InvalidLiteralExpAspectInvalidLiteralExpAspectContext {
  public static final InvalidLiteralExpAspectInvalidLiteralExpAspectContext INSTANCE = new InvalidLiteralExpAspectInvalidLiteralExpAspectContext();
  
  public static InvalidLiteralExpAspectInvalidLiteralExpAspectProperties getSelf(final InvalidLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.InvalidLiteralExpAspectInvalidLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InvalidLiteralExp, InvalidLiteralExpAspectInvalidLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.InvalidLiteralExp, fr.inria.diverse.swhModel.generator.aspects.InvalidLiteralExpAspectInvalidLiteralExpAspectProperties>();
  
  public Map<InvalidLiteralExp, InvalidLiteralExpAspectInvalidLiteralExpAspectProperties> getMap() {
    return map;
  }
}
