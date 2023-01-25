package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.VariableDeclaration;

@Aspect(className = VariableDeclaration.class)
@SuppressWarnings("all")
public abstract class VariableDeclarationAspect extends TypedElementAspect {
}
