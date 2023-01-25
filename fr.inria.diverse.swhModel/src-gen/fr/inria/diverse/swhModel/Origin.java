/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Origin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.Origin#getOriginUrl <em>Origin Url</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Origin#getOriginVisits <em>Origin Visits</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getOrigin()
 * @model
 * @generated
 */
public interface Origin extends Node {

	/**
	 * Returns the value of the '<em><b>Origin Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Url</em>' attribute.
	 * @see #setOriginUrl(String)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getOrigin_OriginUrl()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getOriginUrl();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Origin#getOriginUrl <em>Origin Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin Url</em>' attribute.
	 * @see #getOriginUrl()
	 * @generated
	 */
	void setOriginUrl(String value);

	/**
	 * Returns the value of the '<em><b>Origin Visits</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.swhModel.OriginVisit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin Visits</em>' containment reference list.
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getOrigin_OriginVisits()
	 * @model containment="true"
	 * @generated
	 */
	EList<OriginVisit> getOriginVisits();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Snapshot getLastSnapshot();
} // Origin
