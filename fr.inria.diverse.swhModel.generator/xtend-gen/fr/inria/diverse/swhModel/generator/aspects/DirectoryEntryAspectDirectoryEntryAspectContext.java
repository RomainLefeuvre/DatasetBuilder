package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.DirectoryEntry;
import java.util.Map;

@SuppressWarnings("all")
public class DirectoryEntryAspectDirectoryEntryAspectContext {
  public static final DirectoryEntryAspectDirectoryEntryAspectContext INSTANCE = new DirectoryEntryAspectDirectoryEntryAspectContext();
  
  public static DirectoryEntryAspectDirectoryEntryAspectProperties getSelf(final DirectoryEntry _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DirectoryEntryAspectDirectoryEntryAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DirectoryEntry, DirectoryEntryAspectDirectoryEntryAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.DirectoryEntry, fr.inria.diverse.swhModel.generator.aspects.DirectoryEntryAspectDirectoryEntryAspectProperties>();
  
  public Map<DirectoryEntry, DirectoryEntryAspectDirectoryEntryAspectProperties> getMap() {
    return map;
  }
}
