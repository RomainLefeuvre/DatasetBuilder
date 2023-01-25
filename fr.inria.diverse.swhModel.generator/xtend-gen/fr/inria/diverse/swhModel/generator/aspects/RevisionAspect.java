package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.swhModel.Revision;

@Aspect(className = Revision.class)
@SuppressWarnings("all")
public class RevisionAspect extends SnapshotChildAspect {
}
