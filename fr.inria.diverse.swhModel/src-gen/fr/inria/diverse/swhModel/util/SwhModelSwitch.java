/**
 */
package fr.inria.diverse.swhModel.util;

import fr.inria.diverse.swhModel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.inria.diverse.swhModel.SwhModelPackage
 * @generated
 */
public class SwhModelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SwhModelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwhModelSwitch() {
		if (modelPackage == null) {
			modelPackage = SwhModelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case SwhModelPackage.GRAPH: {
			Graph graph = (Graph) theEObject;
			T result = caseGraph(graph);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.NODE: {
			Node node = (Node) theEObject;
			T result = caseNode(node);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.ORIGIN: {
			Origin origin = (Origin) theEObject;
			T result = caseOrigin(origin);
			if (result == null)
				result = caseNode(origin);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.ORIGIN_VISIT: {
			OriginVisit originVisit = (OriginVisit) theEObject;
			T result = caseOriginVisit(originVisit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.SNAPSHOT: {
			Snapshot snapshot = (Snapshot) theEObject;
			T result = caseSnapshot(snapshot);
			if (result == null)
				result = caseNode(snapshot);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.SNAPSHOT_BRANCH: {
			SnapshotBranch snapshotBranch = (SnapshotBranch) theEObject;
			T result = caseSnapshotBranch(snapshotBranch);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.SNAPSHOT_CHILD: {
			SnapshotChild snapshotChild = (SnapshotChild) theEObject;
			T result = caseSnapshotChild(snapshotChild);
			if (result == null)
				result = caseNode(snapshotChild);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.REVISION: {
			Revision revision = (Revision) theEObject;
			T result = caseRevision(revision);
			if (result == null)
				result = caseSnapshotChild(revision);
			if (result == null)
				result = caseDirectoryChild(revision);
			if (result == null)
				result = caseNode(revision);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.DIRECTORY_CHILD: {
			DirectoryChild directoryChild = (DirectoryChild) theEObject;
			T result = caseDirectoryChild(directoryChild);
			if (result == null)
				result = caseNode(directoryChild);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.CONTENT: {
			Content content = (Content) theEObject;
			T result = caseContent(content);
			if (result == null)
				result = caseDirectoryChild(content);
			if (result == null)
				result = caseNode(content);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.DIRECTORY: {
			Directory directory = (Directory) theEObject;
			T result = caseDirectory(directory);
			if (result == null)
				result = caseDirectoryChild(directory);
			if (result == null)
				result = caseNode(directory);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.DIRECTORY_ENTRY: {
			DirectoryEntry directoryEntry = (DirectoryEntry) theEObject;
			T result = caseDirectoryEntry(directoryEntry);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case SwhModelPackage.RELEASE: {
			Release release = (Release) theEObject;
			T result = caseRelease(release);
			if (result == null)
				result = caseSnapshotChild(release);
			if (result == null)
				result = caseNode(release);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraph(Graph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Origin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Origin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrigin(Origin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Origin Visit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Origin Visit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOriginVisit(OriginVisit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshot(Snapshot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotBranch(SnapshotBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snapshot Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snapshot Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnapshotChild(SnapshotChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Revision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Revision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRevision(Revision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directory Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directory Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectoryChild(DirectoryChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContent(Content object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectory(Directory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Directory Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directory Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectoryEntry(DirectoryEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Release</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Release</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelease(Release object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SwhModelSwitch
