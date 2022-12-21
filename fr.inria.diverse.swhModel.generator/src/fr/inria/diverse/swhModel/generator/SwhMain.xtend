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

class SwhMain{ 

	public def run(String modelPath, String resultModelPath) {
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

		
		selectedPivotModel.generate
		//Pivot_ModelAspect.generate(m);

		// apply transformation
		//res.contents.filter(EPackage).forEach[ pack | pack.annotate]
		
		// save the modified model in a new file
		/*val resSet2 = new  ResourceSetImpl()
		val res2 = resSet2.createResource(URI.createURI(resultModelPath))
		// move content to new resource
		res2.contents.addAll(res.contents)
		res2.save(new HashMap())*/ 
	}

	def static void main(String[] args) {
		println('Hello Kermeta on top of Xtend! (please create a My.ecore file to test this sample program)')
		//new SwhMain().run("tests/resources/swhModelQuery_01/swhModelQuery.oclas", "My_annotated.ecore")
		new SwhMain().run("tests/resources/swhModelQuery_01/swhModelQuery.ocl", "My_annotated.ecore")
		println('file written (please refresh project to see it)')
	}
	
}
