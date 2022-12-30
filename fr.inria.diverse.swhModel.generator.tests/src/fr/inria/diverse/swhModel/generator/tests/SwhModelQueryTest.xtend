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
	def void test_swhModelQuery_ocl_00() {
		val m = loadTestCaseModel("testfiles/test000/swhModelQuery.ocl")
		assertNotNull(m)
		// launch the generation
		val result=m.generate		
		val expectedResult = Files.readString(Paths.get("testfiles/test000/GraphQuery.java"));
		assertEquals(expectedResult,result)
	}
	@Test
	def void test_swhModelQuery_oclas_00() {
		val m = loadTestCaseModel("testfiles/test000/swhModelQuery.ocl.oclas")
		assertNotNull(m)
		// launch the generation
		val result=m.generate
		val expectedResult = Files.readString(Paths.get("testfiles/test000/GraphQuery.java"));
		assertEquals(expectedResult,result)
	}
	
	//Minimal test without explicit iterator variable
	@Test
	def void test_swhModelQuery_ocl_01() {
		val m = loadTestCaseModel("testfiles/test001/swhModelQuery.ocl")
		assertNotNull(m)
		// launch the generation
		val result=m.generate				
		val expectedResult = Files.readString(Paths.get("testfiles/test001/GraphQuery.java"));
		assertEquals(expectedResult,result)
	}
	@Test
	def void test_swhModelQuery_oclas_01() {
		val m = loadTestCaseModel("testfiles/test001/swhModelQuery.ocl.oclas")
		assertNotNull(m)
		// launch the generation
		val result=m.generate
		val expectedResult = Files.readString(Paths.get("testfiles/test001/GraphQuery.java"));
		assertEquals(expectedResult,result)
	}
	
		//Or/and Test
	@Test
	def void test_swhModelQuery_ocl_02() {
		val m = loadTestCaseModel("testfiles/test002/swhModelQuery.ocl")
		assertNotNull(m)
		// launch the generation
		val result=m.generate	
		val expectedResult = Files.readString(Paths.get("testfiles/test002/GraphQuery.java"));
		assertEquals(expectedResult,result)
	}
	@Test
	def void test_swhModelQuery_oclas_02() {
		val m = loadTestCaseModel("testfiles/test002/swhModelQuery.ocl.oclas")
		assertNotNull(m)
		// launch the generation
		val result=m.generate
		val expectedResult = Files.readString(Paths.get("testfiles/test002/GraphQuery.java"));
		assertEquals(expectedResult,result)
	}

	def static writeString(String path,String stringToWrite){
		Files.writeString(Paths.get(path),stringToWrite)	
	}

}
