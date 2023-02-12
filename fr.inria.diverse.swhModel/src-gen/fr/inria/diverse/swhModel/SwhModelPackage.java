/**
 */
package fr.inria.diverse.swhModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.inria.diverse.swhModel.SwhModelFactory
 * @model kind="package"
 * @generated
 */
public interface SwhModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "swhModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/swhModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "swhModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SwhModelPackage eINSTANCE = fr.inria.diverse.swhModel.impl.SwhModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.GraphImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Origins</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__ORIGINS = 0;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__TIMESTAMP = 1;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Query</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH___QUERY = 0;

	/**
	 * The number of operations of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.NodeImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SWHID = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.OriginImpl <em>Origin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.OriginImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getOrigin()
	 * @generated
	 */
	int ORIGIN = 2;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN__SWHID = NODE__SWHID;

	/**
	 * The feature id for the '<em><b>Origin Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN__ORIGIN_URL = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Origin Visits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN__ORIGIN_VISITS = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Origin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Last Snapshot</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN___GET_LAST_SNAPSHOT = NODE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Origin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_OPERATION_COUNT = NODE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.OriginVisitImpl <em>Origin Visit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.OriginVisitImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getOriginVisit()
	 * @generated
	 */
	int ORIGIN_VISIT = 3;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_VISIT__TIMESTAMP = 0;

	/**
	 * The feature id for the '<em><b>Snapshot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_VISIT__SNAPSHOT = 1;

	/**
	 * The number of structural features of the '<em>Origin Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_VISIT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Origin Visit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORIGIN_VISIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.SnapshotImpl <em>Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.SnapshotImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getSnapshot()
	 * @generated
	 */
	int SNAPSHOT = 4;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__SWHID = NODE__SWHID;

	/**
	 * The feature id for the '<em><b>Branches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__BRANCHES = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.SnapshotBranchImpl <em>Snapshot Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.SnapshotBranchImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getSnapshotBranch()
	 * @generated
	 */
	int SNAPSHOT_BRANCH = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_BRANCH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_BRANCH__CHILD = 1;

	/**
	 * The number of structural features of the '<em>Snapshot Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_BRANCH_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Revision</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_BRANCH___GET_REVISION = 0;

	/**
	 * The number of operations of the '<em>Snapshot Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_BRANCH_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.SnapshotChildImpl <em>Snapshot Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.SnapshotChildImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getSnapshotChild()
	 * @generated
	 */
	int SNAPSHOT_CHILD = 6;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_CHILD__SWHID = NODE__SWHID;

	/**
	 * The number of structural features of the '<em>Snapshot Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_CHILD_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Snapshot Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_CHILD_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.RevisionImpl <em>Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.RevisionImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getRevision()
	 * @generated
	 */
	int REVISION = 7;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__SWHID = SNAPSHOT_CHILD__SWHID;

	/**
	 * The feature id for the '<em><b>Tree</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__TREE = SNAPSHOT_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__MESSAGE = SNAPSHOT_CHILD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__AUTHOR = SNAPSHOT_CHILD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__TIMESTAMP = SNAPSHOT_CHILD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Commiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__COMMITER = SNAPSHOT_CHILD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Commiter Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__COMMITER_TIMESTAMP = SNAPSHOT_CHILD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION__PARENT = SNAPSHOT_CHILD_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_FEATURE_COUNT = SNAPSHOT_CHILD_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REVISION_OPERATION_COUNT = SNAPSHOT_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.DirectoryChildImpl <em>Directory Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.DirectoryChildImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getDirectoryChild()
	 * @generated
	 */
	int DIRECTORY_CHILD = 8;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_CHILD__SWHID = NODE__SWHID;

	/**
	 * The number of structural features of the '<em>Directory Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_CHILD_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Directory Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_CHILD_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.ContentImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 9;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__SWHID = DIRECTORY_CHILD__SWHID;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__LENGTH = DIRECTORY_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__STATUS = DIRECTORY_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = DIRECTORY_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OPERATION_COUNT = DIRECTORY_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.DirectoryImpl <em>Directory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.DirectoryImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getDirectory()
	 * @generated
	 */
	int DIRECTORY = 10;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__SWHID = DIRECTORY_CHILD__SWHID;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ENTRIES = DIRECTORY_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_FEATURE_COUNT = DIRECTORY_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_OPERATION_COUNT = DIRECTORY_CHILD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.DirectoryEntryImpl <em>Directory Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.DirectoryEntryImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getDirectoryEntry()
	 * @generated
	 */
	int DIRECTORY_ENTRY = 11;

	/**
	 * The feature id for the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_ENTRY__CHILD = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_ENTRY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Directory Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Directory Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.diverse.swhModel.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.diverse.swhModel.impl.ReleaseImpl
	 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 12;

	/**
	 * The feature id for the '<em><b>Swhid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__SWHID = SNAPSHOT_CHILD__SWHID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__NAME = SNAPSHOT_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__MESSAGE = SNAPSHOT_CHILD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__AUTHOR = SNAPSHOT_CHILD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__TIMESTAMP = SNAPSHOT_CHILD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__REVISION = SNAPSHOT_CHILD_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = SNAPSHOT_CHILD_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_OPERATION_COUNT = SNAPSHOT_CHILD_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see fr.inria.diverse.swhModel.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the reference list '{@link fr.inria.diverse.swhModel.Graph#getOrigins <em>Origins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Origins</em>'.
	 * @see fr.inria.diverse.swhModel.Graph#getOrigins()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Origins();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Graph#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see fr.inria.diverse.swhModel.Graph#getTimestamp()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Timestamp();

	/**
	 * Returns the meta object for the '{@link fr.inria.diverse.swhModel.Graph#query() <em>Query</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Query</em>' operation.
	 * @see fr.inria.diverse.swhModel.Graph#query()
	 * @generated
	 */
	EOperation getGraph__Query();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see fr.inria.diverse.swhModel.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Node#getSwhid <em>Swhid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Swhid</em>'.
	 * @see fr.inria.diverse.swhModel.Node#getSwhid()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Swhid();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Origin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Origin</em>'.
	 * @see fr.inria.diverse.swhModel.Origin
	 * @generated
	 */
	EClass getOrigin();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Origin#getOriginUrl <em>Origin Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin Url</em>'.
	 * @see fr.inria.diverse.swhModel.Origin#getOriginUrl()
	 * @see #getOrigin()
	 * @generated
	 */
	EAttribute getOrigin_OriginUrl();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.diverse.swhModel.Origin#getOriginVisits <em>Origin Visits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Origin Visits</em>'.
	 * @see fr.inria.diverse.swhModel.Origin#getOriginVisits()
	 * @see #getOrigin()
	 * @generated
	 */
	EReference getOrigin_OriginVisits();

	/**
	 * Returns the meta object for the '{@link fr.inria.diverse.swhModel.Origin#getLastSnapshot() <em>Get Last Snapshot</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Last Snapshot</em>' operation.
	 * @see fr.inria.diverse.swhModel.Origin#getLastSnapshot()
	 * @generated
	 */
	EOperation getOrigin__GetLastSnapshot();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.OriginVisit <em>Origin Visit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Origin Visit</em>'.
	 * @see fr.inria.diverse.swhModel.OriginVisit
	 * @generated
	 */
	EClass getOriginVisit();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.OriginVisit#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see fr.inria.diverse.swhModel.OriginVisit#getTimestamp()
	 * @see #getOriginVisit()
	 * @generated
	 */
	EAttribute getOriginVisit_Timestamp();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.swhModel.OriginVisit#getSnapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Snapshot</em>'.
	 * @see fr.inria.diverse.swhModel.OriginVisit#getSnapshot()
	 * @see #getOriginVisit()
	 * @generated
	 */
	EReference getOriginVisit_Snapshot();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Snapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot</em>'.
	 * @see fr.inria.diverse.swhModel.Snapshot
	 * @generated
	 */
	EClass getSnapshot();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.diverse.swhModel.Snapshot#getBranches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Branches</em>'.
	 * @see fr.inria.diverse.swhModel.Snapshot#getBranches()
	 * @see #getSnapshot()
	 * @generated
	 */
	EReference getSnapshot_Branches();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.SnapshotBranch <em>Snapshot Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Branch</em>'.
	 * @see fr.inria.diverse.swhModel.SnapshotBranch
	 * @generated
	 */
	EClass getSnapshotBranch();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.SnapshotBranch#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.diverse.swhModel.SnapshotBranch#getName()
	 * @see #getSnapshotBranch()
	 * @generated
	 */
	EAttribute getSnapshotBranch_Name();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.swhModel.SnapshotBranch#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child</em>'.
	 * @see fr.inria.diverse.swhModel.SnapshotBranch#getChild()
	 * @see #getSnapshotBranch()
	 * @generated
	 */
	EReference getSnapshotBranch_Child();

	/**
	 * Returns the meta object for the '{@link fr.inria.diverse.swhModel.SnapshotBranch#getRevision() <em>Get Revision</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Revision</em>' operation.
	 * @see fr.inria.diverse.swhModel.SnapshotBranch#getRevision()
	 * @generated
	 */
	EOperation getSnapshotBranch__GetRevision();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.SnapshotChild <em>Snapshot Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Child</em>'.
	 * @see fr.inria.diverse.swhModel.SnapshotChild
	 * @generated
	 */
	EClass getSnapshotChild();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Revision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision</em>'.
	 * @see fr.inria.diverse.swhModel.Revision
	 * @generated
	 */
	EClass getRevision();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.swhModel.Revision#getTree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tree</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getTree()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Tree();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Revision#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getMessage()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Message();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Revision#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getAuthor()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Author();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Revision#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getTimestamp()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Revision#getCommiter <em>Commiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commiter</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getCommiter()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_Commiter();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Revision#getCommiterTimestamp <em>Commiter Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Commiter Timestamp</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getCommiterTimestamp()
	 * @see #getRevision()
	 * @generated
	 */
	EAttribute getRevision_CommiterTimestamp();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.swhModel.Revision#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see fr.inria.diverse.swhModel.Revision#getParent()
	 * @see #getRevision()
	 * @generated
	 */
	EReference getRevision_Parent();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.DirectoryChild <em>Directory Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory Child</em>'.
	 * @see fr.inria.diverse.swhModel.DirectoryChild
	 * @generated
	 */
	EClass getDirectoryChild();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see fr.inria.diverse.swhModel.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Content#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see fr.inria.diverse.swhModel.Content#getLength()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Length();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Content#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see fr.inria.diverse.swhModel.Content#getStatus()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Status();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory</em>'.
	 * @see fr.inria.diverse.swhModel.Directory
	 * @generated
	 */
	EClass getDirectory();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.diverse.swhModel.Directory#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see fr.inria.diverse.swhModel.Directory#getEntries()
	 * @see #getDirectory()
	 * @generated
	 */
	EReference getDirectory_Entries();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.DirectoryEntry <em>Directory Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory Entry</em>'.
	 * @see fr.inria.diverse.swhModel.DirectoryEntry
	 * @generated
	 */
	EClass getDirectoryEntry();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.swhModel.DirectoryEntry#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Child</em>'.
	 * @see fr.inria.diverse.swhModel.DirectoryEntry#getChild()
	 * @see #getDirectoryEntry()
	 * @generated
	 */
	EReference getDirectoryEntry_Child();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.DirectoryEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.diverse.swhModel.DirectoryEntry#getName()
	 * @see #getDirectoryEntry()
	 * @generated
	 */
	EAttribute getDirectoryEntry_Name();

	/**
	 * Returns the meta object for class '{@link fr.inria.diverse.swhModel.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see fr.inria.diverse.swhModel.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Release#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.diverse.swhModel.Release#getName()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Release#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see fr.inria.diverse.swhModel.Release#getMessage()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Message();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Release#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see fr.inria.diverse.swhModel.Release#getAuthor()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Author();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.diverse.swhModel.Release#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see fr.inria.diverse.swhModel.Release#getTimestamp()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Timestamp();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.diverse.swhModel.Release#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Revision</em>'.
	 * @see fr.inria.diverse.swhModel.Release#getRevision()
	 * @see #getRelease()
	 * @generated
	 */
	EReference getRelease_Revision();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SwhModelFactory getSwhModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.GraphImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Origins</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__ORIGINS = eINSTANCE.getGraph_Origins();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__TIMESTAMP = eINSTANCE.getGraph_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GRAPH___QUERY = eINSTANCE.getGraph__Query();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.NodeImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Swhid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__SWHID = eINSTANCE.getNode_Swhid();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.OriginImpl <em>Origin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.OriginImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getOrigin()
		 * @generated
		 */
		EClass ORIGIN = eINSTANCE.getOrigin();

		/**
		 * The meta object literal for the '<em><b>Origin Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGIN__ORIGIN_URL = eINSTANCE.getOrigin_OriginUrl();

		/**
		 * The meta object literal for the '<em><b>Origin Visits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGIN__ORIGIN_VISITS = eINSTANCE.getOrigin_OriginVisits();

		/**
		 * The meta object literal for the '<em><b>Get Last Snapshot</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ORIGIN___GET_LAST_SNAPSHOT = eINSTANCE.getOrigin__GetLastSnapshot();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.OriginVisitImpl <em>Origin Visit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.OriginVisitImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getOriginVisit()
		 * @generated
		 */
		EClass ORIGIN_VISIT = eINSTANCE.getOriginVisit();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORIGIN_VISIT__TIMESTAMP = eINSTANCE.getOriginVisit_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Snapshot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORIGIN_VISIT__SNAPSHOT = eINSTANCE.getOriginVisit_Snapshot();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.SnapshotImpl <em>Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.SnapshotImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getSnapshot()
		 * @generated
		 */
		EClass SNAPSHOT = eINSTANCE.getSnapshot();

		/**
		 * The meta object literal for the '<em><b>Branches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT__BRANCHES = eINSTANCE.getSnapshot_Branches();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.SnapshotBranchImpl <em>Snapshot Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.SnapshotBranchImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getSnapshotBranch()
		 * @generated
		 */
		EClass SNAPSHOT_BRANCH = eINSTANCE.getSnapshotBranch();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_BRANCH__NAME = eINSTANCE.getSnapshotBranch_Name();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_BRANCH__CHILD = eINSTANCE.getSnapshotBranch_Child();

		/**
		 * The meta object literal for the '<em><b>Get Revision</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SNAPSHOT_BRANCH___GET_REVISION = eINSTANCE.getSnapshotBranch__GetRevision();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.SnapshotChildImpl <em>Snapshot Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.SnapshotChildImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getSnapshotChild()
		 * @generated
		 */
		EClass SNAPSHOT_CHILD = eINSTANCE.getSnapshotChild();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.RevisionImpl <em>Revision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.RevisionImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getRevision()
		 * @generated
		 */
		EClass REVISION = eINSTANCE.getRevision();

		/**
		 * The meta object literal for the '<em><b>Tree</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__TREE = eINSTANCE.getRevision_Tree();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__MESSAGE = eINSTANCE.getRevision_Message();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__AUTHOR = eINSTANCE.getRevision_Author();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__TIMESTAMP = eINSTANCE.getRevision_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Commiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__COMMITER = eINSTANCE.getRevision_Commiter();

		/**
		 * The meta object literal for the '<em><b>Commiter Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REVISION__COMMITER_TIMESTAMP = eINSTANCE.getRevision_CommiterTimestamp();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REVISION__PARENT = eINSTANCE.getRevision_Parent();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.DirectoryChildImpl <em>Directory Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.DirectoryChildImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getDirectoryChild()
		 * @generated
		 */
		EClass DIRECTORY_CHILD = eINSTANCE.getDirectoryChild();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.ContentImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__LENGTH = eINSTANCE.getContent_Length();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__STATUS = eINSTANCE.getContent_Status();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.DirectoryImpl <em>Directory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.DirectoryImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getDirectory()
		 * @generated
		 */
		EClass DIRECTORY = eINSTANCE.getDirectory();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTORY__ENTRIES = eINSTANCE.getDirectory_Entries();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.DirectoryEntryImpl <em>Directory Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.DirectoryEntryImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getDirectoryEntry()
		 * @generated
		 */
		EClass DIRECTORY_ENTRY = eINSTANCE.getDirectoryEntry();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIRECTORY_ENTRY__CHILD = eINSTANCE.getDirectoryEntry_Child();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY_ENTRY__NAME = eINSTANCE.getDirectoryEntry_Name();

		/**
		 * The meta object literal for the '{@link fr.inria.diverse.swhModel.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.diverse.swhModel.impl.ReleaseImpl
		 * @see fr.inria.diverse.swhModel.impl.SwhModelPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__NAME = eINSTANCE.getRelease_Name();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__MESSAGE = eINSTANCE.getRelease_Message();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__AUTHOR = eINSTANCE.getRelease_Author();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__TIMESTAMP = eINSTANCE.getRelease_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE__REVISION = eINSTANCE.getRelease_Revision();

	}

} //SwhModelPackage
