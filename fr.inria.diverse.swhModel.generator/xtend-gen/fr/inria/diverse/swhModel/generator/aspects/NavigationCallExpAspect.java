package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.NavigationCallExp;

@Aspect(className = NavigationCallExp.class)
@SuppressWarnings("all")
public abstract class NavigationCallExpAspect extends FeatureCallExpAspect {
}
