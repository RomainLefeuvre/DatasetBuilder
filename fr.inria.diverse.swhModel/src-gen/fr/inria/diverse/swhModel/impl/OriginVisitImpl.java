/**
 */
package fr.inria.diverse.swhModel.impl;

import fr.inria.diverse.swhModel.OriginVisit;
import fr.inria.diverse.swhModel.Snapshot;
import fr.inria.diverse.swhModel.SwhModelPackage;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Origin Visit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fr.inria.diverse.swhModel.impl.OriginVisitImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link fr.inria.diverse.swhModel.impl.OriginVisitImpl#getSnapshot <em>Snapshot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OriginVisitImpl extends MinimalEObjectImpl.Container implements OriginVisit {
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
	 * The cached value of the '{@link #getSnapshot() <em>Snapshot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshot()
	 * @generated
	 * @ordered
	 */
	protected Snapshot snapshot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OriginVisitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SwhModelPackage.Literals.ORIGIN_VISIT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.ORIGIN_VISIT__TIMESTAMP, oldTimestamp,
					timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot getSnapshot() {
		if (snapshot != null && snapshot.eIsProxy()) {
			InternalEObject oldSnapshot = (InternalEObject) snapshot;
			snapshot = (Snapshot) eResolveProxy(oldSnapshot);
			if (snapshot != oldSnapshot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SwhModelPackage.ORIGIN_VISIT__SNAPSHOT,
							oldSnapshot, snapshot));
			}
		}
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot basicGetSnapshot() {
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshot(Snapshot newSnapshot) {
		Snapshot oldSnapshot = snapshot;
		snapshot = newSnapshot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SwhModelPackage.ORIGIN_VISIT__SNAPSHOT, oldSnapshot,
					snapshot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SwhModelPackage.ORIGIN_VISIT__TIMESTAMP:
			return getTimestamp();
		case SwhModelPackage.ORIGIN_VISIT__SNAPSHOT:
			if (resolve)
				return getSnapshot();
			return basicGetSnapshot();
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
		case SwhModelPackage.ORIGIN_VISIT__TIMESTAMP:
			setTimestamp((Long) newValue);
			return;
		case SwhModelPackage.ORIGIN_VISIT__SNAPSHOT:
			setSnapshot((Snapshot) newValue);
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
		case SwhModelPackage.ORIGIN_VISIT__TIMESTAMP:
			setTimestamp(TIMESTAMP_EDEFAULT);
			return;
		case SwhModelPackage.ORIGIN_VISIT__SNAPSHOT:
			setSnapshot((Snapshot) null);
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
		case SwhModelPackage.ORIGIN_VISIT__TIMESTAMP:
			return timestamp != TIMESTAMP_EDEFAULT;
		case SwhModelPackage.ORIGIN_VISIT__SNAPSHOT:
			return snapshot != null;
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
		result.append(" (timestamp: ");
		result.append(timestamp);
		result.append(')');
		return result.toString();
	}

} //OriginVisitImpl
