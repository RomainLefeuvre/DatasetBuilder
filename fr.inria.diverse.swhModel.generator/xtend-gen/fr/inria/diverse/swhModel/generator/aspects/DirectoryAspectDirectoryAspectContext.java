package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Directory;
import java.util.Map;

@SuppressWarnings("all")
public class DirectoryAspectDirectoryAspectContext {
  public static final DirectoryAspectDirectoryAspectContext INSTANCE = new DirectoryAspectDirectoryAspectContext();
  
  public static DirectoryAspectDirectoryAspectProperties getSelf(final Directory _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DirectoryAspectDirectoryAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Directory, DirectoryAspectDirectoryAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Directory, fr.inria.diverse.swhModel.generator.aspects.DirectoryAspectDirectoryAspectProperties>();
  
  public Map<Directory, DirectoryAspectDirectoryAspectProperties> getMap() {
    return map;
  }
}
