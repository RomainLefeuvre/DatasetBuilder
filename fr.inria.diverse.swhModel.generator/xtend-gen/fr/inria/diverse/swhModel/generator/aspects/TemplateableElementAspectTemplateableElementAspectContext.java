package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TemplateableElement;

@SuppressWarnings("all")
public class TemplateableElementAspectTemplateableElementAspectContext {
  public static final TemplateableElementAspectTemplateableElementAspectContext INSTANCE = new TemplateableElementAspectTemplateableElementAspectContext();
  
  public static TemplateableElementAspectTemplateableElementAspectProperties getSelf(final TemplateableElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TemplateableElementAspectTemplateableElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemplateableElement, TemplateableElementAspectTemplateableElementAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TemplateableElement, fr.inria.diverse.swhModel.generator.aspects.TemplateableElementAspectTemplateableElementAspectProperties>();
  
  public Map<TemplateableElement, TemplateableElementAspectTemplateableElementAspectProperties> getMap() {
    return map;
  }
}
