/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.Snapshot#getBranches <em>Branches</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getSnapshot()
 * @model
 * @generated
 */
public interface Snapshot extends Node {
	/**
	 * Returns the value of the '<em><b>Branches</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.swhModel.SnapshotBranch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' containment reference list.
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getSnapshot_Branches()
	 * @model containment="true"
	 * @generated
	 */
	EList<SnapshotBranch> getBranches();

} // Snapshot
