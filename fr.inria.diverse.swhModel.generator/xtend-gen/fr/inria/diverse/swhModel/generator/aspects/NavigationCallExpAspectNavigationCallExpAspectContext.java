package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.NavigationCallExp;

@SuppressWarnings("all")
public class NavigationCallExpAspectNavigationCallExpAspectContext {
  public static final NavigationCallExpAspectNavigationCallExpAspectContext INSTANCE = new NavigationCallExpAspectNavigationCallExpAspectContext();
  
  public static NavigationCallExpAspectNavigationCallExpAspectProperties getSelf(final NavigationCallExp _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.NavigationCallExpAspectNavigationCallExpAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NavigationCallExp, NavigationCallExpAspectNavigationCallExpAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.NavigationCallExp, fr.inria.diverse.swhModel.generator.aspects.NavigationCallExpAspectNavigationCallExpAspectProperties>();
  
  public Map<NavigationCallExp, NavigationCallExpAspectNavigationCallExpAspectProperties> getMap() {
    return map;
  }
}
