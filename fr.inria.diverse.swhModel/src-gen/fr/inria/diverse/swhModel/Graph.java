/**
 */
package fr.inria.diverse.swhModel;

import javax.xml.datatype.XMLGregorianCalendar;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.Graph#getOrigins <em>Origins</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Graph#getTimestamp <em>Timestamp</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Origins</b></em>' reference list.
	 * The list contents are of type {@link fr.inria.diverse.swhModel.Origin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origins</em>' reference list.
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getGraph_Origins()
	 * @model
	 * @generated
	 */
	EList<Origin> getOrigins();

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(XMLGregorianCalendar)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getGraph_Timestamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 * @generated
	 */
	XMLGregorianCalendar getTimestamp();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Graph#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(XMLGregorianCalendar value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Graph query();

} // Graph
