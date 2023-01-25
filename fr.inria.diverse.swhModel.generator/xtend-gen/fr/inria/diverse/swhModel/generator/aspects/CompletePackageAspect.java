package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.CompletePackage;

@Aspect(className = CompletePackage.class)
@SuppressWarnings("all")
public class CompletePackageAspect extends NamedElementAspect {
}
