package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Aspect(className = OCLExpression.class)
@SuppressWarnings("all")
public abstract class OCLExpressionAspect extends TypedElementAspect {
  public static String generate(final OCLExpression _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspectOCLExpressionAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspectOCLExpressionAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.PropertyCallExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspect.generate((org.eclipse.ocl.pivot.PropertyCallExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.VariableExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.VariableExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.VariableExpAspect.generate((org.eclipse.ocl.pivot.VariableExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.VariableExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.LiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.LiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.LiteralExpAspect.generate((org.eclipse.ocl.pivot.LiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.LiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.IntegerLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect.generate((org.eclipse.ocl.pivot.IntegerLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.PrimitiveLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect.generate((org.eclipse.ocl.pivot.PrimitiveLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.OperationCallExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspect.generate((org.eclipse.ocl.pivot.OperationCallExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.StringLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect.generate((org.eclipse.ocl.pivot.StringLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.BooleanLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect.generate((org.eclipse.ocl.pivot.BooleanLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.TypeExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.TypeExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.TypeExpAspect.generate((org.eclipse.ocl.pivot.TypeExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.TypeExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IfExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.IfExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.IfExpAspect.generate((org.eclipse.ocl.pivot.IfExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IfExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.IteratorExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspect.generate((org.eclipse.ocl.pivot.IteratorExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspect
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.OCLExpression){
    	result = fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.OCLExpression)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final OCLExpressionAspectOCLExpressionAspectProperties _self_, final OCLExpression _self, final Context context) {
    try {
      throw new Exception("Not implemented ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
