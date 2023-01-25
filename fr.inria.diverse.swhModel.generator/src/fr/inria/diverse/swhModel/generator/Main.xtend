package fr.inria.diverse.swhModel.generator;

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI

import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import fr.inria.diverse.swhModel.SwhModelPackage
import org.eclipse.ocl.pivot.Model

import static extension fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect.*
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource
import org.eclipse.ocl.pivot.resource.ASResource
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup
import java.nio.file.Files
import java.nio.file.Paths
import org.eclipse.emf.ecore.resource.URIConverter
import java.io.File
import java.net.URL
import java.nio.file.Path

class Main{ 
	/**
	 * Main method of our generator
	 *   modelPath : the path of the ocl model (either .ocl or the abstract syntax saved in .oclas)
	 *   savePath : the path where the generation will be saved
	 *   queryId : the queryId 
	 */
	public def run(String modelPath, String savePath, String queryId) {
		println('''Launching generation for the model : «modelPath», output path : «savePath» ,query id : «queryId»''')
		//Register ecore factory
		var fact = new EcoreResourceFactoryImpl
		if (!EPackage.Registry.INSTANCE.containsKey(EcorePackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE)
		}
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", fact)
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl())
		//Registering OCL ecore
		PivotStandaloneSetup.doSetup()
		CompleteOCLStandaloneSetup.doSetup()
		//Add mapping to resolve swhModel.ecore import on OCL files
		print(this.getClass().getClassLoader().getResource("swhModel.ecore").toString())
		URIConverter.URI_MAP.put(URI.createURI("platform:/resource/fr.inria.diverse.swhModel/model/swhModel.ecore"), 
			URI.createURI(class.classLoader.getResource("swhModel.ecore").toString)
		)
		//Load SwhModel by accessing an attribute, here the eClass
		SwhModelPackage.eINSTANCE.eClass();
		//Loading the input ocl or oclas model
		var rs = new ResourceSetImpl()
		var uri = URI.createURI(modelPath)
		var res = rs.getResource(uri, true)
		//Detect if it is an ocl file or an oclas (abstract syntax) and load it properly
		var Model selectedPivotModel
		if (res instanceof BaseCSResource) {
			var ASResource asResource = (res as BaseCSResource).getASResource()
			selectedPivotModel = asResource.getModel()
		}
		else {
			selectedPivotModel = res.getContents().get(0) as Model
		}		
		println("Model loaded, starting generation...")
		//Launch the generation 
		val results = selectedPivotModel.generate(queryId)
		println("Generation done, saving results in "+savePath)
		//Writing result to the requested path
		writeString(savePath,results)
		println('Result saved')
		
	}
	
	/**
	 * Save a string to a file 
	 *   path : the output path
	 *   stringToWrite : the string that will be saved
	 */
	def static writeString(String path,String stringToWrite){
		Files.createDirectories(Paths.get(path).parent)
		Files.writeString(Paths.get(path),stringToWrite)	
	}

	def static void main(String[] args) {
		new Main().run(args.get(0), args.get(1),args.get(2))
	}
	
	
	
	
	
}
