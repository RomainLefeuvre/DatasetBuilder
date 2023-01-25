/**
 */
package fr.inria.diverse.swhModel.impl;

import fr.inria.diverse.swhModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SwhModelFactoryImpl extends EFactoryImpl implements SwhModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SwhModelFactory init() {
		try {
			SwhModelFactory theSwhModelFactory = (SwhModelFactory) EPackage.Registry.INSTANCE
					.getEFactory(SwhModelPackage.eNS_URI);
			if (theSwhModelFactory != null) {
				return theSwhModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SwhModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwhModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case SwhModelPackage.GRAPH:
			return createGraph();
		case SwhModelPackage.ORIGIN:
			return createOrigin();
		case SwhModelPackage.ORIGIN_VISIT:
			return createOriginVisit();
		case SwhModelPackage.SNAPSHOT:
			return createSnapshot();
		case SwhModelPackage.SNAPSHOT_BRANCH:
			return createSnapshotBranch();
		case SwhModelPackage.REVISION:
			return createRevision();
		case SwhModelPackage.CONTENT:
			return createContent();
		case SwhModelPackage.DIRECTORY:
			return createDirectory();
		case SwhModelPackage.DIRECTORY_ENTRY:
			return createDirectoryEntry();
		case SwhModelPackage.RELEASE:
			return createRelease();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph createGraph() {
		GraphImpl graph = new GraphImpl();
		return graph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Origin createOrigin() {
		OriginImpl origin = new OriginImpl();
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OriginVisit createOriginVisit() {
		OriginVisitImpl originVisit = new OriginVisitImpl();
		return originVisit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Snapshot createSnapshot() {
		SnapshotImpl snapshot = new SnapshotImpl();
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SnapshotBranch createSnapshotBranch() {
		SnapshotBranchImpl snapshotBranch = new SnapshotBranchImpl();
		return snapshotBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Revision createRevision() {
		RevisionImpl revision = new RevisionImpl();
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Content createContent() {
		ContentImpl content = new ContentImpl();
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Directory createDirectory() {
		DirectoryImpl directory = new DirectoryImpl();
		return directory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectoryEntry createDirectoryEntry() {
		DirectoryEntryImpl directoryEntry = new DirectoryEntryImpl();
		return directoryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwhModelPackage getSwhModelPackage() {
		return (SwhModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SwhModelPackage getPackage() {
		return SwhModelPackage.eINSTANCE;
	}

} //SwhModelFactoryImpl
