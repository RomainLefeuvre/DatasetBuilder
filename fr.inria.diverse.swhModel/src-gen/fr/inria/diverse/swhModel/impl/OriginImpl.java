/**
 */
package fr.inria.diverse.swhModel.impl;

import fr.inria.diverse.swhModel.Origin;
import fr.inria.diverse.swhModel.OriginVisit;
import fr.inria.diverse.swhModel.Snapshot;
import fr.inria.diverse.swhModel.SwhModelPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Origin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.impl.OriginImpl#getOriginUrl <em>Origin Url</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.OriginImpl#getOriginVisits <em>Origin Visits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OriginImpl extends NodeImpl implements Origin {
	/**
	 * The default value of the '{@link #getOriginUrl() <em>Origin Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_URL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOriginUrl() <em>Origin Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginUrl()
	 * @generated
	 * @ordered
	 */
	protected String originUrl = ORIGIN_URL_EDEFAULT;
	/**
	 * The cached value of the '{@link #getOriginVisits() <em>Origin Visits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginVisits()
	 * @generated
	 * @ordered
	 */
	protected EList<OriginVisit> originVisits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OriginImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SwhModelPackage.Literals.ORIGIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginUrl() {
		return originUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginUrl(String newOriginUrl) {
		String oldOriginUrl = originUrl;
		originUrl = newOriginUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.ORIGIN__ORIGIN_URL, oldOriginUrl,
					originUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OriginVisit> getOriginVisits() {
		if (originVisits == null) {
			originVisits = new EObjectContainmentEList<OriginVisit>(OriginVisit.class, this,
					SwhModelPackage.ORIGIN__ORIGIN_VISITS);
		}
		return originVisits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot getLastSnapshot() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SwhModelPackage.ORIGIN__ORIGIN_VISITS:
			return ((InternalEList<?>) getOriginVisits()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SwhModelPackage.ORIGIN__ORIGIN_URL:
			return getOriginUrl();
		case SwhModelPackage.ORIGIN__ORIGIN_VISITS:
			return getOriginVisits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SwhModelPackage.ORIGIN__ORIGIN_URL:
			setOriginUrl((String) newValue);
			return;
		case SwhModelPackage.ORIGIN__ORIGIN_VISITS:
			getOriginVisits().clear();
			getOriginVisits().addAll((Collection<? extends OriginVisit>) newValue);
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
		case SwhModelPackage.ORIGIN__ORIGIN_URL:
			setOriginUrl(ORIGIN_URL_EDEFAULT);
			return;
		case SwhModelPackage.ORIGIN__ORIGIN_VISITS:
			getOriginVisits().clear();
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
		case SwhModelPackage.ORIGIN__ORIGIN_URL:
			return ORIGIN_URL_EDEFAULT == null ? originUrl != null : !ORIGIN_URL_EDEFAULT.equals(originUrl);
		case SwhModelPackage.ORIGIN__ORIGIN_VISITS:
			return originVisits != null && !originVisits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case SwhModelPackage.ORIGIN___GET_LAST_SNAPSHOT:
			return getLastSnapshot();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (originUrl: ");
		result.append(originUrl);
		result.append(')');
		return result.toString();
	}

} //OriginImpl
