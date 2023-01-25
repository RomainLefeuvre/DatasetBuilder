package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.FeatureCallExp;

@Aspect(className = FeatureCallExp.class)
@SuppressWarnings("all")
public abstract class FeatureCallExpAspect extends CallExpAspect {
}
