package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.AssociationClassCallExp;

@Aspect(className = AssociationClassCallExp.class)
@SuppressWarnings("all")
public class AssociationClassCallExpAspect extends NavigationCallExpAspect {
}
