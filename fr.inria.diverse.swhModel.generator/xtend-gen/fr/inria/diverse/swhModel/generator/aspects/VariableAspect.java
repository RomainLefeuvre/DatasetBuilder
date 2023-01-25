package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.Variable;

@Aspect(className = Variable.class)
@SuppressWarnings("all")
public class VariableAspect extends VariableDeclarationAspect {
}
