package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.StandardLibrary;

@SuppressWarnings("all")
public class StandardLibraryAspectStandardLibraryAspectContext {
  public static final StandardLibraryAspectStandardLibraryAspectContext INSTANCE = new StandardLibraryAspectStandardLibraryAspectContext();
  
  public static StandardLibraryAspectStandardLibraryAspectProperties getSelf(final StandardLibrary _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.StandardLibraryAspectStandardLibraryAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<StandardLibrary, StandardLibraryAspectStandardLibraryAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.StandardLibrary, fr.inria.diverse.swhModel.generator.aspects.StandardLibraryAspectStandardLibraryAspectProperties>();
  
  public Map<StandardLibrary, StandardLibraryAspectStandardLibraryAspectProperties> getMap() {
    return map;
  }
}
