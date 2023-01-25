package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;

@Aspect(className = OppositePropertyCallExp.class)
@SuppressWarnings("all")
public class OppositePropertyCallExpAspect extends NavigationCallExpAspect {
}
