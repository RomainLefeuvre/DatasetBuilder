/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.Node#getSwhid <em>Swhid</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {

	/**
	 * Returns the value of the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Swhid</em>' attribute.
	 * @see #setSwhid(String)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getNode_Swhid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getSwhid();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Node#getSwhid <em>Swhid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Swhid</em>' attribute.
	 * @see #getSwhid()
	 * @generated
	 */
	void setSwhid(String value);
} // Node
