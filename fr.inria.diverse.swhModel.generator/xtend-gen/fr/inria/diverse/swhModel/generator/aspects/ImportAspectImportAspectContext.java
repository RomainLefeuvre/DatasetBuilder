package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Import;

@SuppressWarnings("all")
public class ImportAspectImportAspectContext {
  public static final ImportAspectImportAspectContext INSTANCE = new ImportAspectImportAspectContext();
  
  public static ImportAspectImportAspectProperties getSelf(final Import _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.ImportAspectImportAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Import, ImportAspectImportAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Import, fr.inria.diverse.swhModel.generator.aspects.ImportAspectImportAspectProperties>();
  
  public Map<Import, ImportAspectImportAspectProperties> getMap() {
    return map;
  }
}
