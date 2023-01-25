package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.NullLiteralExp;

@Aspect(className = NullLiteralExp.class)
@SuppressWarnings("all")
public class NullLiteralExpAspect extends PrimitiveLiteralExpAspect {
}
