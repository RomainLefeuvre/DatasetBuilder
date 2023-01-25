package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.SequenceType;

@SuppressWarnings("all")
public class SequenceTypeAspectSequenceTypeAspectContext {
  public static final SequenceTypeAspectSequenceTypeAspectContext INSTANCE = new SequenceTypeAspectSequenceTypeAspectContext();
  
  public static SequenceTypeAspectSequenceTypeAspectProperties getSelf(final SequenceType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.SequenceTypeAspectSequenceTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<SequenceType, SequenceTypeAspectSequenceTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.SequenceType, fr.inria.diverse.swhModel.generator.aspects.SequenceTypeAspectSequenceTypeAspectProperties>();
  
  public Map<SequenceType, SequenceTypeAspectSequenceTypeAspectProperties> getMap() {
    return map;
  }
}
