package fr.inria.diverse.swhModel.generator.tests;

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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SuppressWarnings("all")
public class SwhModelQueryTest {
  @BeforeEach
  public void SetUpBeforeClass() {
    PivotStandaloneSetup.doSetup();
    CompleteOCLStandaloneSetup.doSetup();
    SwhModelPackage.eINSTANCE.eClass();
    URIConverter.URI_MAP.put(URI.createURI("platform:/resource/fr.inria.diverse.swhModel/model/swhModel.ecore"), 
      URI.createURI(this.getClass().getClassLoader().getResource("swhModel.ecore").toString()));
  }
  
  private Model loadTestCaseModel(final String caseName) {
    Model _xblockexpression = null;
    {
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
      final URI sourceuri = URI.createFileURI(caseName);
      ResourceSetImpl rs = new ResourceSetImpl();
      final Resource res = rs.getResource(sourceuri, true);
      Model selectedPivotModel = null;
      Model _xifexpression = null;
      if ((res instanceof BaseCSResource)) {
        Model _xblockexpression_1 = null;
        {
          ASResource asResource = ((BaseCSResource) res).getASResource();
          _xblockexpression_1 = selectedPivotModel = asResource.getModel();
        }
        _xifexpression = _xblockexpression_1;
      } else {
        EObject _get = res.getContents().get(0);
        _xifexpression = selectedPivotModel = ((Model) _get);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Test
  public void test_swhModelQuery_ocl_000() {
    this.genericTest(0, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_oclas_000() {
    this.genericTest(0, Boolean.valueOf(true));
  }
  
  @Test
  public void test_swhModelQuery_ocl_001() {
    this.genericTest(1, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_oclas_001() {
    this.genericTest(1, Boolean.valueOf(true));
  }
  
  @Test
  public void test_swhModelQuery_ocl_002() {
    this.genericTest(2, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_oclas_002() {
    this.genericTest(2, Boolean.valueOf(true));
  }
  
  @Test
  public void test_swhModelQuery_ocl_003() {
    this.genericTest(3, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_ocl_004() {
    this.genericTest(4, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_ocl_005() {
    this.genericTest(5, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_ocl_006() {
    this.genericTest(6, Boolean.valueOf(false));
  }
  
  @Test
  public void test_swhModelQuery_ocl_007() {
    this.genericTest(7, Boolean.valueOf(false));
  }
  
  /**
   * Perform a basic test comparing computed and expected file result
   * 	asInput : whether it take as input the abstract syntax file or the concrete syntax
   *  testNb: the test number in 3 digit
   */
  public String genericTest(final int nb, final Boolean asInput) {
    try {
      String _xblockexpression = null;
      {
        final String testNb = String.format("%03d", Integer.valueOf(nb));
        final String resourceDirectory = Paths.get("src", "test", "resources").toString();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(resourceDirectory);
        _builder.append("/test");
        _builder.append(testNb);
        _builder.append("/swhModelQuery.ocl");
        String _xifexpression = null;
        if ((asInput).booleanValue()) {
          _xifexpression = ".oclas";
        } else {
          _xifexpression = "";
        }
        _builder.append(_xifexpression);
        final Model m = this.loadTestCaseModel(_builder.toString());
        Assertions.assertNotNull(m);
        final String result = Pivot_ModelAspect.generate(m, "testQuery");
        SwhModelQueryTest.writeString((("target/testfiles/test" + testNb) + "/GraphQuery.java_"), result);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(resourceDirectory);
        _builder_1.append("/test");
        _builder_1.append(testNb);
        _builder_1.append("/GraphQuery.java_");
        final String expectedResult = Files.readString(Paths.get(_builder_1.toString()));
        Assertions.assertEquals(expectedResult, result);
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
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
}
