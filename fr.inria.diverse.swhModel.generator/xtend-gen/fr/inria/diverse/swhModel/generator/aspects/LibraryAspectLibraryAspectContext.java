package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Library;

@SuppressWarnings("all")
public class LibraryAspectLibraryAspectContext {
  public static final LibraryAspectLibraryAspectContext INSTANCE = new LibraryAspectLibraryAspectContext();
  
  public static LibraryAspectLibraryAspectProperties getSelf(final Library _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.LibraryAspectLibraryAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Library, LibraryAspectLibraryAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Library, fr.inria.diverse.swhModel.generator.aspects.LibraryAspectLibraryAspectProperties>();
  
  public Map<Library, LibraryAspectLibraryAspectProperties> getMap() {
    return map;
  }
}
