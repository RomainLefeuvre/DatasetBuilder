package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.StringLiteralExp;

@SuppressWarnings("all")
public class StringLiteralExpAspectStringLiteralExpAspectContext {
  public static final StringLiteralExpAspectStringLiteralExpAspectContext INSTANCE = new StringLiteralExpAspectStringLiteralExpAspectContext();
  
  public static StringLiteralExpAspectStringLiteralExpAspectProperties getSelf(final StringLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspectStringLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StringLiteralExp, StringLiteralExpAspectStringLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.StringLiteralExp, fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspectStringLiteralExpAspectProperties>();
  
  public Map<StringLiteralExp, StringLiteralExpAspectStringLiteralExpAspectProperties> getMap() {
    return map;
  }
}
