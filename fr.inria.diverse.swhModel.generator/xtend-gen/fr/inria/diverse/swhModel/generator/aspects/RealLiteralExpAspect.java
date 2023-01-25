package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.RealLiteralExp;

@Aspect(className = RealLiteralExp.class)
@SuppressWarnings("all")
public class RealLiteralExpAspect extends NumericLiteralExpAspect {
}
