package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.NumericLiteralExp;

@Aspect(className = NumericLiteralExp.class)
@SuppressWarnings("all")
public abstract class NumericLiteralExpAspect extends PrimitiveLiteralExpAspect {
}
