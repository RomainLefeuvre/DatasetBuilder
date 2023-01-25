package fr.inria.diverse.swhModel.generator.aspects;

import java.util.Map;
import org.eclipse.ocl.pivot.Annotation;

@SuppressWarnings("all")
public class AnnotationAspectAnnotationAspectContext {
  public static final AnnotationAspectAnnotationAspectContext INSTANCE = new AnnotationAspectAnnotationAspectContext();
  
  public static AnnotationAspectAnnotationAspectProperties getSelf(final Annotation _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new fr.inria.diverse.swhModel.generator.aspects.AnnotationAspectAnnotationAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Annotation, AnnotationAspectAnnotationAspectProperties> map = new java.util.WeakHashMap<org.eclipse.ocl.pivot.Annotation, fr.inria.diverse.swhModel.generator.aspects.AnnotationAspectAnnotationAspectProperties>();
  
  public Map<Annotation, AnnotationAspectAnnotationAspectProperties> getMap() {
    return map;
  }
}
