package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.DataType;

@SuppressWarnings("all")
public class DataTypeAspectDataTypeAspectContext {
  public static final DataTypeAspectDataTypeAspectContext INSTANCE = new DataTypeAspectDataTypeAspectContext();
  
  public static DataTypeAspectDataTypeAspectProperties getSelf(final DataType _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.DataTypeAspectDataTypeAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<DataType, DataTypeAspectDataTypeAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.DataType, fr.inria.diverse.swhModel.generator.aspects.DataTypeAspectDataTypeAspectProperties>();
  
  public Map<DataType, DataTypeAspectDataTypeAspectProperties> getMap() {
    return map;
  }
}
