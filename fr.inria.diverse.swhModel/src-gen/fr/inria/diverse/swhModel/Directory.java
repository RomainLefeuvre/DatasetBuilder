/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.Directory#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see fr.inria.diverse.swhModel.SwhModelPackage#getDirectory()
 * @model
 * @generated
 */
public interface Directory extends DirectoryChild {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.diverse.swhModel.DirectoryEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see fr.inria.diverse.swhModel.SwhModelPackage#getDirectory_Entries()
	 * @model containment="true"
	 * @generated
	 */
	EList<DirectoryEntry> getEntries();

} // Directory
