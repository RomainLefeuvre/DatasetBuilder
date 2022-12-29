package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.swhModel.Graph

import fr.inria.diverse.swhModel.Node
import fr.inria.diverse.swhModel.Origin
import fr.inria.diverse.swhModel.OriginVisit
import fr.inria.diverse.swhModel.Snapshot
import fr.inria.diverse.swhModel.SnapshotBranch
import fr.inria.diverse.swhModel.SnapshotChild
import fr.inria.diverse.swhModel.Revision
import fr.inria.diverse.swhModel.DirectoryChild
import fr.inria.diverse.swhModel.Content
import fr.inria.diverse.swhModel.Directory
import fr.inria.diverse.swhModel.DirectoryEntry
import fr.inria.diverse.swhModel.Release
/*
import static extension fr.inria.diverse.swhModel.aspects.GraphAspect.*
import static extension fr.inria.diverse.swhModel.aspects.NodeAspect.*
import static extension fr.inria.diverse.swhModel.aspects.OriginAspect.*
import static extension fr.inria.diverse.swhModel.aspects.OriginVisitAspect.*
import static extension fr.inria.diverse.swhModel.aspects.SnapshotAspect.*
import static extension fr.inria.diverse.swhModel.aspects.SnapshotBranchAspect.*
import static extension fr.inria.diverse.swhModel.aspects.SnapshotChildAspect.*
import static extension fr.inria.diverse.swhModel.aspects.RevisionAspect.*
import static extension fr.inria.diverse.swhModel.aspects.DirectoryChildAspect.*
import static extension fr.inria.diverse.swhModel.aspects.ContentAspect.*
import static extension fr.inria.diverse.swhModel.aspects.DirectoryAspect.*
import static extension fr.inria.diverse.swhModel.aspects.DirectoryEntryAspect.*
import static extension fr.inria.diverse.swhModel.aspects.ReleaseAspect.*
*/
@Aspect(className=Graph)
class GraphAspect {

}

@Aspect(className=Node)
abstract class NodeAspect {

}

@Aspect(className=Origin)
class OriginAspect extends NodeAspect {

}

@Aspect(className=OriginVisit)
class OriginVisitAspect {

}

@Aspect(className=Snapshot)
class SnapshotAspect extends NodeAspect {

}

@Aspect(className=SnapshotBranch)
class SnapshotBranchAspect {

}

@Aspect(className=SnapshotChild)
abstract class SnapshotChildAspect extends NodeAspect {

}

@Aspect(className=Revision)
class RevisionAspect extends SnapshotChildAspect {
	/*
	* BE CAREFUL :
	*
	* This class has more than one superclass
	* please specify which parent you want with the 'super' expected calling
	*
	*/


}

@Aspect(className=DirectoryChild)
abstract class DirectoryChildAspect extends NodeAspect {

}

@Aspect(className=Content)
class ContentAspect extends DirectoryChildAspect {

}

@Aspect(className=Directory)
class DirectoryAspect extends DirectoryChildAspect {

}

@Aspect(className=DirectoryEntry)
class DirectoryEntryAspect {

}

@Aspect(className=Release)
class ReleaseAspect extends SnapshotChildAspect {

}



