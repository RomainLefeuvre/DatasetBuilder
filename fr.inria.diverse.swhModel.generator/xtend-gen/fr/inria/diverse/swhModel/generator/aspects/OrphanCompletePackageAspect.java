package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.OrphanCompletePackage;

@Aspect(className = OrphanCompletePackage.class)
@SuppressWarnings("all")
public class OrphanCompletePackageAspect extends CompletePackageAspect {
}
