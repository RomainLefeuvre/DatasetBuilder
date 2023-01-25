/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Origin Visit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.OriginVisit#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.OriginVisit#getSnapshot <em>Snapshot</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getOriginVisit()
 * @model
 * @generated
 */
public interface OriginVisit extends EObject {
	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(long)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getOriginVisit_Timestamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Long"
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.OriginVisit#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Snapshot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot</em>' reference.
	 * @see #setSnapshot(Snapshot)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getOriginVisit_Snapshot()
	 * @model
	 * @generated
	 */
	Snapshot getSnapshot();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.OriginVisit#getSnapshot <em>Snapshot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot</em>' reference.
	 * @see #getSnapshot()
	 * @generated
	 */
	void setSnapshot(Snapshot value);

} // OriginVisit
