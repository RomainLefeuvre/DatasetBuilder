package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.Feature;

@Aspect(className = Feature.class)
@SuppressWarnings("all")
public abstract class FeatureAspect extends TypedElementAspect {
}
