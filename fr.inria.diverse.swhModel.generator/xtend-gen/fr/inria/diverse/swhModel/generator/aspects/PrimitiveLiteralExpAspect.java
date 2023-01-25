package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;

@Aspect(className = PrimitiveLiteralExp.class)
@SuppressWarnings("all")
public abstract class PrimitiveLiteralExpAspect extends LiteralExpAspect {
  public static String generate(final PrimitiveLiteralExp _self, final Context context) {
    final fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties _self_ = fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectContext.getSelf(_self);
    Object result = null;
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.StringLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect.generate((org.eclipse.ocl.pivot.StringLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.BooleanLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect.generate((org.eclipse.ocl.pivot.BooleanLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect
    	// BeginInjectInto fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect
    		if (_self instanceof org.eclipse.ocl.pivot.IntegerLiteralExp){
    			result = fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect.generate((org.eclipse.ocl.pivot.IntegerLiteralExp)_self,context);
    		} else
    		// EndInjectInto fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect#String generate(Context) from fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect
    // #DispatchPointCut_before# String generate(Context)
    if (_self instanceof org.eclipse.ocl.pivot.PrimitiveLiteralExp){
    	result = fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect._privk3_generate(_self_, (org.eclipse.ocl.pivot.PrimitiveLiteralExp)_self,context);
    };
    return (java.lang.String)result;
  }
  
  protected static String _privk3_generate(final PrimitiveLiteralExpAspectPrimitiveLiteralExpAspectProperties _self_, final PrimitiveLiteralExp _self, final Context context) {
    return _self.getName();
  }
}
