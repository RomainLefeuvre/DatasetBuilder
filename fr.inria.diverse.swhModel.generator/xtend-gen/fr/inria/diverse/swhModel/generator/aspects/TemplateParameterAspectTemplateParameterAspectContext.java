package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TemplateParameter;

@SuppressWarnings("all")
public class TemplateParameterAspectTemplateParameterAspectContext {
  public static final TemplateParameterAspectTemplateParameterAspectContext INSTANCE = new TemplateParameterAspectTemplateParameterAspectContext();
  
  public static TemplateParameterAspectTemplateParameterAspectProperties getSelf(final TemplateParameter _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TemplateParameterAspectTemplateParameterAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemplateParameter, TemplateParameterAspectTemplateParameterAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TemplateParameter, fr.inria.diverse.swhModel.generator.aspects.TemplateParameterAspectTemplateParameterAspectProperties>();
  
  public Map<TemplateParameter, TemplateParameterAspectTemplateParameterAspectProperties> getMap() {
    return map;
  }
}
