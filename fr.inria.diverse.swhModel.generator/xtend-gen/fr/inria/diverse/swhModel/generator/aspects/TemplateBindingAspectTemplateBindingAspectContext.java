package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TemplateBinding;

@SuppressWarnings("all")
public class TemplateBindingAspectTemplateBindingAspectContext {
  public static final TemplateBindingAspectTemplateBindingAspectContext INSTANCE = new TemplateBindingAspectTemplateBindingAspectContext();
  
  public static TemplateBindingAspectTemplateBindingAspectProperties getSelf(final TemplateBinding _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TemplateBindingAspectTemplateBindingAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemplateBinding, TemplateBindingAspectTemplateBindingAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TemplateBinding, fr.inria.diverse.swhModel.generator.aspects.TemplateBindingAspectTemplateBindingAspectProperties>();
  
  public Map<TemplateBinding, TemplateBindingAspectTemplateBindingAspectProperties> getMap() {
    return map;
  }
}
