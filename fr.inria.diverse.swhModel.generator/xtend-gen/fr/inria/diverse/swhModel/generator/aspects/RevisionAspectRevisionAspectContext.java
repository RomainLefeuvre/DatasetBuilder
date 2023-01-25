package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.swhModel.Revision;
import java.util.Map;

@SuppressWarnings("all")
public class RevisionAspectRevisionAspectContext {
  public static final RevisionAspectRevisionAspectContext INSTANCE = new RevisionAspectRevisionAspectContext();
  
  public static RevisionAspectRevisionAspectProperties getSelf(final Revision _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.RevisionAspectRevisionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Revision, RevisionAspectRevisionAspectProperties> map = new java.util.WeakHashMap<fr.inria.diverse.swhModel.Revision, fr.inria.diverse.swhModel.generator.aspects.RevisionAspectRevisionAspectProperties>();
  
  public Map<Revision, RevisionAspectRevisionAspectProperties> getMap() {
    return map;
  }
}
