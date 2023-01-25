package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.Namespace;

@Aspect(className = Namespace.class)
@SuppressWarnings("all")
public abstract class NamespaceAspect extends NamedElementAspect {
}
