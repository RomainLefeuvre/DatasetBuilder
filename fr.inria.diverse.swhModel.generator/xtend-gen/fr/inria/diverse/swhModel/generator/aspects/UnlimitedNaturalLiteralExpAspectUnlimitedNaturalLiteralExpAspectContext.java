package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp;

@SuppressWarnings("all")
public class UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectContext {
  public static final UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectContext INSTANCE = new UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectContext();
  
  public static UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectProperties getSelf(final UnlimitedNaturalLiteralExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<UnlimitedNaturalLiteralExp, UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp, fr.inria.diverse.swhModel.generator.aspects.UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectProperties>();
  
  public Map<UnlimitedNaturalLiteralExp, UnlimitedNaturalLiteralExpAspectUnlimitedNaturalLiteralExpAspectProperties> getMap() {
    return map;
  }
}
