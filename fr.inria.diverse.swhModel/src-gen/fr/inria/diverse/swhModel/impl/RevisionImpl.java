/**
 */
package fr.inria.diverse.swhModel.impl;

import fr.inria.diverse.swhModel.Directory;
import fr.inria.diverse.swhModel.Revision;
import fr.inria.diverse.swhModel.SwhModelPackage;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getTree <em>Tree</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getCommiter <em>Commiter</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getCommiterTimestamp <em>Commiter Timestamp</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.RevisionImpl#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RevisionImpl extends SnapshotChildImpl implements Revision {
	/**
	 * The cached value of the '{@link #getTree() <em>Tree</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTree()
	 * @generated
	 * @ordered
	 */
	protected Directory tree;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected long timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommiter() <em>Commiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommiter()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMITER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommiter() <em>Commiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommiter()
	 * @generated
	 * @ordered
	 */
	protected String commiter = COMMITER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommiterTimestamp() <em>Commiter Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommiterTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar COMMITER_TIMESTAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommiterTimestamp() <em>Commiter Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommiterTimestamp()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar commiterTimestamp = COMMITER_TIMESTAMP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Revision parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RevisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SwhModelPackage.Literals.REVISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Directory getTree() {
		if (tree != null && tree.eIsProxy()) {
			InternalEObject oldTree = (InternalEObject) tree;
			tree = (Directory) eResolveProxy(oldTree);
			if (tree != oldTree) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SwhModelPackage.REVISION__TREE, oldTree,
							tree));
			}
		}
		return tree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Directory basicGetTree() {
		return tree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTree(Directory newTree) {
		Directory oldTree = tree;
		tree = newTree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__TREE, oldTree, tree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__MESSAGE, oldMessage,
					message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestamp(long newTimestamp) {
		long oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__TIMESTAMP, oldTimestamp,
					timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCommiter() {
		return commiter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommiter(String newCommiter) {
		String oldCommiter = commiter;
		commiter = newCommiter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__COMMITER, oldCommiter,
					commiter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getCommiterTimestamp() {
		return commiterTimestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCommiterTimestamp(XMLGregorianCalendar newCommiterTimestamp) {
		XMLGregorianCalendar oldCommiterTimestamp = commiterTimestamp;
		commiterTimestamp = newCommiterTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__COMMITER_TIMESTAMP,
					oldCommiterTimestamp, commiterTimestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject) parent;
			parent = (Revision) eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SwhModelPackage.REVISION__PARENT,
							oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Revision newParent) {
		Revision oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.REVISION__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SwhModelPackage.REVISION__TREE:
			if (resolve)
				return getTree();
			return basicGetTree();
		case SwhModelPackage.REVISION__MESSAGE:
			return getMessage();
		case SwhModelPackage.REVISION__AUTHOR:
			return getAuthor();
		case SwhModelPackage.REVISION__TIMESTAMP:
			return getTimestamp();
		case SwhModelPackage.REVISION__COMMITER:
			return getCommiter();
		case SwhModelPackage.REVISION__COMMITER_TIMESTAMP:
			return getCommiterTimestamp();
		case SwhModelPackage.REVISION__PARENT:
			if (resolve)
				return getParent();
			return basicGetParent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SwhModelPackage.REVISION__TREE:
			setTree((Directory) newValue);
			return;
		case SwhModelPackage.REVISION__MESSAGE:
			setMessage((String) newValue);
			return;
		case SwhModelPackage.REVISION__AUTHOR:
			setAuthor((String) newValue);
			return;
		case SwhModelPackage.REVISION__TIMESTAMP:
			setTimestamp((Long) newValue);
			return;
		case SwhModelPackage.REVISION__COMMITER:
			setCommiter((String) newValue);
			return;
		case SwhModelPackage.REVISION__COMMITER_TIMESTAMP:
			setCommiterTimestamp((XMLGregorianCalendar) newValue);
			return;
		case SwhModelPackage.REVISION__PARENT:
			setParent((Revision) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SwhModelPackage.REVISION__TREE:
			setTree((Directory) null);
			return;
		case SwhModelPackage.REVISION__MESSAGE:
			setMessage(MESSAGE_EDEFAULT);
			return;
		case SwhModelPackage.REVISION__AUTHOR:
			setAuthor(AUTHOR_EDEFAULT);
			return;
		case SwhModelPackage.REVISION__TIMESTAMP:
			setTimestamp(TIMESTAMP_EDEFAULT);
			return;
		case SwhModelPackage.REVISION__COMMITER:
			setCommiter(COMMITER_EDEFAULT);
			return;
		case SwhModelPackage.REVISION__COMMITER_TIMESTAMP:
			setCommiterTimestamp(COMMITER_TIMESTAMP_EDEFAULT);
			return;
		case SwhModelPackage.REVISION__PARENT:
			setParent((Revision) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SwhModelPackage.REVISION__TREE:
			return tree != null;
		case SwhModelPackage.REVISION__MESSAGE:
			return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
		case SwhModelPackage.REVISION__AUTHOR:
			return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
		case SwhModelPackage.REVISION__TIMESTAMP:
			return timestamp != TIMESTAMP_EDEFAULT;
		case SwhModelPackage.REVISION__COMMITER:
			return COMMITER_EDEFAULT == null ? commiter != null : !COMMITER_EDEFAULT.equals(commiter);
		case SwhModelPackage.REVISION__COMMITER_TIMESTAMP:
			return COMMITER_TIMESTAMP_EDEFAULT == null ? commiterTimestamp != null
					: !COMMITER_TIMESTAMP_EDEFAULT.equals(commiterTimestamp);
		case SwhModelPackage.REVISION__PARENT:
			return parent != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (message: ");
		result.append(message);
		result.append(", author: ");
		result.append(author);
		result.append(", timestamp: ");
		result.append(timestamp);
		result.append(", commiter: ");
		result.append(commiter);
		result.append(", commiterTimestamp: ");
		result.append(commiterTimestamp);
		result.append(')');
		return result.toString();
	}

} //RevisionImpl
