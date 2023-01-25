package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.EnumerationLiteral;

@SuppressWarnings("all")
public class EnumerationLiteralAspectEnumerationLiteralAspectContext {
  public static final EnumerationLiteralAspectEnumerationLiteralAspectContext INSTANCE = new EnumerationLiteralAspectEnumerationLiteralAspectContext();
  
  public static EnumerationLiteralAspectEnumerationLiteralAspectProperties getSelf(final EnumerationLiteral _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.EnumerationLiteralAspectEnumerationLiteralAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<EnumerationLiteral, EnumerationLiteralAspectEnumerationLiteralAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.EnumerationLiteral, fr.inria.diverse.swhModel.generator.aspects.EnumerationLiteralAspectEnumerationLiteralAspectProperties>();
  
  public Map<EnumerationLiteral, EnumerationLiteralAspectEnumerationLiteralAspectProperties> getMap() {
    return map;
  }
}
