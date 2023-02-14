/**
 */
package fr.inria.diverse.swhModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Revision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getTree <em>Tree</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getMessage <em>Message</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getAuthor <em>Author</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getCommiter <em>Commiter</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getCommiterTimestamp <em>Commiter Timestamp</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.Revision#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision()
 * @model
 * @generated
 */
public interface Revision extends SnapshotChild, DirectoryChild {
	/**
	 * Returns the value of the '<em><b>Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tree</em>' reference.
	 * @see #setTree(Directory)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_Tree()
	 * @model
	 * @generated
	 */
	Directory getTree();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getTree <em>Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tree</em>' reference.
	 * @see #getTree()
	 * @generated
	 */
	void setTree(Directory value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_Message()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_Author()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(long)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_Timestamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Long"
	 * @generated
	 */
	long getTimestamp();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Commiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commiter</em>' attribute.
	 * @see #setCommiter(String)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_Commiter()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getCommiter();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getCommiter <em>Commiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commiter</em>' attribute.
	 * @see #getCommiter()
	 * @generated
	 */
	void setCommiter(String value);

	/**
	 * Returns the value of the '<em><b>Commiter Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commiter Timestamp</em>' attribute.
	 * @see #setCommiterTimestamp(long)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_CommiterTimestamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Long"
	 * @generated
	 */
	long getCommiterTimestamp();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getCommiterTimestamp <em>Commiter Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commiter Timestamp</em>' attribute.
	 * @see #getCommiterTimestamp()
	 * @generated
	 */
	void setCommiterTimestamp(long value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Revision)
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getRevision_Parent()
	 * @model
	 * @generated
	 */
	Revision getParent();

	/**
	 * Sets the value of the '{@link fr.inria.diverse.swhModel.Revision#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Revision value);

} // Revision
