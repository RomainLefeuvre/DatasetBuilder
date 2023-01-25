package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.CollectionType;

@Aspect(className = CollectionType.class)
@SuppressWarnings("all")
public class CollectionTypeAspect extends IterableTypeAspect {
}
