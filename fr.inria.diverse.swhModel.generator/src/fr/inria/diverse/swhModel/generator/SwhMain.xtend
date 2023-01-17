package fr.inria.diverse.swhModel.generator;

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI

import static extension fr.inria.diverse.swhModel.generator.EPackageAspect.*
import java.util.HashMap
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import fr.inria.diverse.swhModel.SwhModelPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.ocl.pivot.Model
import fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect

import static extension fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect.*
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource
import org.eclipse.ocl.pivot.resource.ASResource
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup
import java.nio.file.Files
import java.nio.file.Paths

class SwhMain{ 

	public def run(String modelPath, String savePath, String queryId) {
		//Load Ecore Model
		var fact = new EcoreResourceFactoryImpl
		if (!EPackage.Registry.INSTANCE.containsKey(EcorePackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", fact);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl())
		
		PivotStandaloneSetup.doSetup();
		CompleteOCLStandaloneSetup.doSetup();
		SwhModelPackage.eINSTANCE.eClass();
		
		var rs = new ResourceSetImpl()
		var uri = URI.createURI(modelPath);
		var res = rs.getResource(uri, true);
		
		
		var Model selectedPivotModel
		if (res instanceof BaseCSResource) {
			var ASResource asResource = (res as BaseCSResource).getASResource();
			selectedPivotModel = asResource.getModel();
		}
		else {
			selectedPivotModel = res.getContents().get(0) as Model;
		}		
		val results = selectedPivotModel.generate(queryId)
		writeString(savePath,results)

	}

	def static void main(String[] args) {
		println(args.get(0))
		//new SwhMain().run("tests/resources/swhModelQuery_01/swhModelQuery.oclas", "My_annotated.ecore")
		//new SwhMain().run("tests/resources/swhModelQuery_00/swhModelQuery.ocl", "tests/resources/swhModelQuery_00/test_query.java","test_query")
		new SwhMain().run(args.get(0), args.get(1),args.get(2))
		println('file written (please refresh project to see it)')
	}
	
	def static writeString(String path,String stringToWrite){
		Files.createDirectories(Paths.get(path).parent);
		Files.writeString(Paths.get(path),stringToWrite)	
	}
	
}
