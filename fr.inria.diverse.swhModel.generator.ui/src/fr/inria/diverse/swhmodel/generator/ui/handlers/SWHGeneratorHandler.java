package fr.inria.diverse.swhmodel.generator.ui.handlers;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;

public class SWHGeneratorHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
		IFile selectedIFile = null;
		// get selectedIFile form selection
		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			for (@SuppressWarnings("unchecked")
				Iterator<Object> iterator = strucSelection.iterator(); 
				iterator.hasNext();) {
				
				Object element = iterator.next();

				if (element instanceof IFile) {
					selectedIFile = (IFile) element;
				}
			}
		}
		
		if(selectedIFile != null) {
			Model selectedPivotModel;
			
			URI uri = URI.createPlatformResourceURI(selectedIFile.getFullPath().toString(), true);
			ResourceSet resSet = new  ResourceSetImpl();
			Resource res = resSet.getResource(uri, true);
			if (res instanceof BaseCSResource) {
				ASResource asResource = ((BaseCSResource)res).getASResource();
				selectedPivotModel = asResource.getModel();
			}
			else {
				selectedPivotModel = (Model) res.getContents().get(0);
			}
			
			Job job = new Job("Generate query for SWH OCL file " + selectedIFile.getName() ) {
				protected IStatus run(IProgressMonitor monitor) {
					SubMonitor submonitor = SubMonitor.convert(monitor, 100);
					
					Pivot_ModelAspect.generate(selectedPivotModel);
					
					submonitor.done();
					return Status.OK_STATUS;
				}
			};
			job.setPriority(Job.LONG);
			// prevent concurrent job in the same project
			job.setRule(selectedIFile.getProject());
			job.schedule();
		} else {
			MessageDialog.openError(
					window.getShell(),
					"SWH OCL Generator",
					"Please select an ocl or oclas file");
		}
		
		return null;
	}
}
