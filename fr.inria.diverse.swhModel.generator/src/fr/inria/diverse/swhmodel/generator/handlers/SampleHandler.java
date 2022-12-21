package fr.inria.diverse.swhmodel.generator.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.inria.diverse.swhModel.generator.EPackageAspect;
import fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ocl.pivot.Model;

public class SampleHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		/*MessageDialog.openInformation(
				window.getShell(),
				"Generator",
				"Hello, Eclipse world");
		*/
		ResourceSet resSet = new  ResourceSetImpl();
		
		Resource res = resSet.getResource(URI.createURI("platform:/resource/fr.inria.diverse.swhModel.ocl/model/swhModelQuery.ocl.oclas"), true);
		//res.getContents().get(0).eClass().eResource().getURI()
		//EcoreUtil.resolveAll(res)
		EObject o = res.getContents().get(0);
		System.out.println(o);
		Model m = (Model) o;
		
		
		Pivot_ModelAspect.generate(m);
		
		
		return null;
	}
}
