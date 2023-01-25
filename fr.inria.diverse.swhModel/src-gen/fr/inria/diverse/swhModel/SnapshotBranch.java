/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.SnapshotBranch#getName <em>Name</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.SnapshotBranch#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getSnapshotBranch()
 * @model
 * @generated
 */
public interface SnapshotBranch extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getSnapshotBranch_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.SnapshotBranch#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' reference.
	 * @see #setChild(SnapshotChild)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getSnapshotBranch_Child()
	 * @model
	 * @generated
	 */
	SnapshotChild getChild();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.SnapshotBranch#getChild <em>Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(SnapshotChild value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Revision getRevision();

} // SnapshotBranch
