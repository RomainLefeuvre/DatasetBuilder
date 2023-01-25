package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.Parameter;

@Aspect(className = Parameter.class)
@SuppressWarnings("all")
public class ParameterAspect extends VariableDeclarationAspect {
}
