package fr.inria.diverse.swhModel.generator;

import fr.inria.diverse.swhModel.SwhModelPackage;
import fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.PivotStandaloneSetup;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Main {
  /**
   * Main method of our generator
   *   modelPath : the path of the ocl model (either .ocl or the abstract syntax saved in .oclas)
   *   savePath : the path where the generation will be saved
   *   queryId : the queryId
   */
  public String run(final String modelPath, final String savePath, final String queryId) {
    String _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Launching generation for the model : ");
      _builder.append(modelPath);
      _builder.append(", output path : ");
      _builder.append(savePath);
      _builder.append(" ,query id : ");
      _builder.append(queryId);
      InputOutput.<String>println(_builder.toString());
      EcoreResourceFactoryImpl fact = new EcoreResourceFactoryImpl();
      boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(EcorePackage.eNS_URI);
      boolean _not = (!_containsKey);
      if (_not) {
        EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
      }
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", fact);
      Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("*", _xMIResourceFactoryImpl);
      PivotStandaloneSetup.doSetup();
      CompleteOCLStandaloneSetup.doSetup();
      URIConverter.URI_MAP.put(URI.createURI("platform:/resource/fr.inria.diverse.swhModel/model/swhModel.ecore"), 
        URI.createURI(this.getClass().getClassLoader().getResource("swhModel.ecore").toString()));
      SwhModelPackage.eINSTANCE.eClass();
      ResourceSetImpl rs = new ResourceSetImpl();
      URI uri = URI.createURI(modelPath);
      Resource res = rs.getResource(uri, true);
      Model selectedPivotModel = null;
      if ((res instanceof BaseCSResource)) {
        ASResource asResource = ((BaseCSResource) res).getASResource();
        selectedPivotModel = asResource.getModel();
      } else {
        EObject _get = res.getContents().get(0);
        selectedPivotModel = ((Model) _get);
      }
      InputOutput.<String>println("Model loaded, starting generation...");
      final String results = Pivot_ModelAspect.generate(selectedPivotModel, queryId);
      InputOutput.<String>println(("Generation done, saving results in " + savePath));
      Main.writeString(savePath, results);
      _xblockexpression = InputOutput.<String>println("Result saved");
    }
    return _xblockexpression;
  }
  
  /**
   * Save a string to a file
   *   path : the output path
   *   stringToWrite : the string that will be saved
   */
  public static Path writeString(final String path, final String stringToWrite) {
    try {
      Path _xblockexpression = null;
      {
        Files.createDirectories(Paths.get(path).getParent());
        _xblockexpression = Files.writeString(Paths.get(path), stringToWrite);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void main(final String[] args) {
    new Main().run(args[0], args[1], args[2]);
  }
}
