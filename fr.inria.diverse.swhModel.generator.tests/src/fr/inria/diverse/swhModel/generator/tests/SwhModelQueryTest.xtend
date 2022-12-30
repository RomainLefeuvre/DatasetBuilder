package fr.inria.diverse.swhModel.generator.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.jupiter.api.BeforeEach
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.serializer.ISerializer
import static org.junit.jupiter.api.Assertions.assertLinesMatch
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup
import fr.inria.diverse.swhModel.SwhModelPackage
import org.eclipse.ocl.pivot.Model
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource
import org.eclipse.ocl.pivot.resource.ASResource


import static extension fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect.*
import static extension org.junit.jupiter.api.Assertions.*
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.nio.file.Files
import java.nio.file.Paths

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation)
class SwhModelQueryTest {


	@BeforeEach
	def void SetUpBeforeClass() {
		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		
		
		SwhModelPackage.eINSTANCE.eClass();
	}
	
	private def Model loadTestCaseModel(String caseName) {
		
		var fact = new EcoreResourceFactoryImpl
		if (!EPackage.Registry.INSTANCE.containsKey(EcorePackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", fact);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl())
		
		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		
		val sourceuri = URI.createFileURI(caseName)
		var rs = new ResourceSetImpl()
		val res = rs.getResource(sourceuri, true)
		
		var Model selectedPivotModel
		if (res instanceof BaseCSResource) {
			var ASResource asResource = (res as BaseCSResource).getASResource();
			selectedPivotModel = asResource.getModel();
		}
		else {
			selectedPivotModel = res.getContents().get(0) as Model;
		}

		
	}
	
	//Minimal test
	@Test
	def void test_swhModelQuery_ocl_000() {
		genericTest(0,false)
	}
	@Test
	def void test_swhModelQuery_oclas_000() {
		genericTest(0,true)
		
	}
	
	//Minimal test without explicit iterator variable
	@Test
	def void test_swhModelQuery_ocl_001() {
		genericTest(1,false)

	}
	@Test
	def void test_swhModelQuery_oclas_001() {
		genericTest(1,true)

	}
	
	//Or/and Test
	@Test
	def void test_swhModelQuery_ocl_002() {
		genericTest(2,false)

	}
	@Test
	def void test_swhModelQuery_oclas_002() {
		genericTest(2,true)
	}
	
	//model method call
	@Test
	def void test_swhModelQuery_ocl_003() {
		genericTest(3,false)
	}
	/**
	 * Perform a basic test comparing computed and expected file result
	 * 	asInput : wether it take as input the abstract syntax file or the concrete syntax
	 *  testNb: the test number in 3 digit
	 */
	def String genericTest(int nb,Boolean asInput){
		val String testNb = String.format("%03d", nb);
	
		val m = loadTestCaseModel('''testfiles/test«testNb»/swhModelQuery.ocl«asInput?".oclas":""»''')
		assertNotNull(m)
		 //launch the generation
		val result=m.generate	
		val expectedResult = Files.readString(Paths.get("testfiles/test"+testNb+"/GraphQuery.java"));
		assertEquals(expectedResult,result)
		result
	}

	def static writeString(String path,String stringToWrite){
		Files.writeString(Paths.get(path),stringToWrite)	
	}

}
