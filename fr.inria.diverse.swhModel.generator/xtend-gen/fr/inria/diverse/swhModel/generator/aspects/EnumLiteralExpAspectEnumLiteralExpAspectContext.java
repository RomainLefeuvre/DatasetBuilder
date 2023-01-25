package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.EnumLiteralExp;

@SuppressWarnings("all")
public class EnumLiteralExpAspectEnumLiteralExpAspectContext {
  public static final EnumLiteralExpAspectEnumLiteralExpAspectContext INSTANCE = new EnumLiteralExpAspectEnumLiteralExpAspectContext();
  
  public static EnumLiteralExpAspectEnumLiteralExpAspectProperties getSelf(final EnumLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.EnumLiteralExpAspectEnumLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<EnumLiteralExp, EnumLiteralExpAspectEnumLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.EnumLiteralExp, fr.inria.diverse.swhModel.generator.aspects.EnumLiteralExpAspectEnumLiteralExpAspectProperties>();
  
  public Map<EnumLiteralExp, EnumLiteralExpAspectEnumLiteralExpAspectProperties> getMap() {
    return map;
  }
}
