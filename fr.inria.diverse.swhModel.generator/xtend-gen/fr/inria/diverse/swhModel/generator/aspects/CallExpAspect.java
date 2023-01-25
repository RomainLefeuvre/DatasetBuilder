package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.CallExp;

@Aspect(className = CallExp.class)
@SuppressWarnings("all")
public abstract class CallExpAspect extends OCLExpressionAspect {
}
