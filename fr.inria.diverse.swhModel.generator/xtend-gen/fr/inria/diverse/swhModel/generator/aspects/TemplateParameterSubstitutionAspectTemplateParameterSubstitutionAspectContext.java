package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.TemplateParameterSubstitution;

@SuppressWarnings("all")
public class TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectContext {
  public static final TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectContext INSTANCE = new TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectContext();
  
  public static TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectProperties getSelf(final TemplateParameterSubstitution _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemplateParameterSubstitution, TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.TemplateParameterSubstitution, fr.inria.diverse.swhModel.generator.aspects.TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectProperties>();
  
  public Map<TemplateParameterSubstitution, TemplateParameterSubstitutionAspectTemplateParameterSubstitutionAspectProperties> getMap() {
    return map;
  }
}
