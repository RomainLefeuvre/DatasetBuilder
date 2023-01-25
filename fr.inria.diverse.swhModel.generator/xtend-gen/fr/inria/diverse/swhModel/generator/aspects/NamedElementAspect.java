package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.NamedElement;

@Aspect(className = NamedElement.class)
@SuppressWarnings("all")
public abstract class NamedElementAspect extends ElementAspect {
}
