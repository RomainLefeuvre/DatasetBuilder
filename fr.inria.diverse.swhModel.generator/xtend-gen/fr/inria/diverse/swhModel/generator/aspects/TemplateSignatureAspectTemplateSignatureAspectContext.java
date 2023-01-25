package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TemplateSignature;

@SuppressWarnings("all")
public class TemplateSignatureAspectTemplateSignatureAspectContext {
  public static final TemplateSignatureAspectTemplateSignatureAspectContext INSTANCE = new TemplateSignatureAspectTemplateSignatureAspectContext();
  
  public static TemplateSignatureAspectTemplateSignatureAspectProperties getSelf(final TemplateSignature _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TemplateSignatureAspectTemplateSignatureAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemplateSignature, TemplateSignatureAspectTemplateSignatureAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TemplateSignature, fr.inria.diverse.swhModel.generator.aspects.TemplateSignatureAspectTemplateSignatureAspectProperties>();
  
  public Map<TemplateSignature, TemplateSignatureAspectTemplateSignatureAspectProperties> getMap() {
    return map;
  }
}
