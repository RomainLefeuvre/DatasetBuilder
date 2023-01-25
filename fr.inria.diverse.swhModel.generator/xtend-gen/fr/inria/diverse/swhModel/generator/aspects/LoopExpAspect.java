package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.LoopExp;

@Aspect(className = LoopExp.class)
@SuppressWarnings("all")
public abstract class LoopExpAspect extends CallExpAspect {
}
