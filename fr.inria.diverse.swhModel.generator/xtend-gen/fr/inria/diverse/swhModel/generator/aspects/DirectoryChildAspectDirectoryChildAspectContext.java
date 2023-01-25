package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.DirectoryChild;
import java.util.Map;

@SuppressWarnings("all")
public class DirectoryChildAspectDirectoryChildAspectContext {
  public static final DirectoryChildAspectDirectoryChildAspectContext INSTANCE = new DirectoryChildAspectDirectoryChildAspectContext();
  
  public static DirectoryChildAspectDirectoryChildAspectProperties getSelf(final DirectoryChild _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DirectoryChildAspectDirectoryChildAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DirectoryChild, DirectoryChildAspectDirectoryChildAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.DirectoryChild, fr.inria.diverse.swhModel.generator.aspects.DirectoryChildAspectDirectoryChildAspectProperties>();
  
  public Map<DirectoryChild, DirectoryChildAspectDirectoryChildAspectProperties> getMap() {
    return map;
  }
}
