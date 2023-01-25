package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.LetExp;

@Aspect(className = LetExp.class)
@SuppressWarnings("all")
public class LetExpAspect extends OCLExpressionAspect {
}
