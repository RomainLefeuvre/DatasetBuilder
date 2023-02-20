package fr.inria.diverse.swhModel.generator.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.ocl.pivot.IfExp
import static extension fr.inria.diverse.swhModel.generator.aspects.IfExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IteratorExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TypeExpAspect.*

import org.eclipse.ocl.pivot.Model
import org.eclipse.ocl.pivot.IteratorExp
import org.eclipse.ocl.pivot.TypeExp
import org.eclipse.ocl.pivot.CollectionType

@Aspect(className=IfExp)
	class IfExpAspect extends OCLExpressionAspect {
		def String generate(Context context){
			//Todo Handle any type ?
			'''
			((«_self.ownedCondition.generate(context)»)?
				(«_self.ownedThen.generate(context)»):
				(«_self.ownedElse.generate(context)»)
			)		
			'''
		}

	}
	
@Aspect(className=IteratorExp)
class IteratorExpAspect extends LoopExpAspect {
	def String generate(Context context){
		val Context c =context.clone()
		val propertyToSearchIn =_self.ownedSource.generate(context)
		
		var iteratorVariable = _self.ownedIterators.get(0).name
		if(iteratorVariable.equals("1_")){
			var source=_self.ownedSource.name
			iteratorVariable=source!=null && !source.equals("oclAsSet")?source.substring(0,source.length-1):"var_"+context.globalContext.getNextVar()
		}
		c.iteratorVariable = iteratorVariable;
		
		//Get the iterator variable
		switch _self.name{
			case "select":{
			'''		
			List<Long> selectResult = new LambdaExplorer<Long, Long>(g, «propertyToSearchIn»,id) {
			    @Override
				public Long exploreGraphNodeActionOnElement(Long currentElement, SwhUnidirectionalGraph graphCopy) {
				    Origin «iteratorVariable» = new Origin(currentElement, this.graph);
				    boolean predicateResult = «_self.ownedBody.generate(c)»;
				    return predicateResult ? currentElement : null;
				    
				}
			}.explore();
			results.addAll(selectResult);
			'''
			}
			case "exists":{
				'''
				«propertyToSearchIn».stream().anyMatch(«iteratorVariable» ->
					«_self.ownedBody.generate(c)»
				)'''
			}case "forAll":{
				'''
				«propertyToSearchIn».stream().allMatch(«iteratorVariable» ->
					«_self.ownedBody.generate(c)»
				)'''
			}
			case "sortedBy":{
				//Todo manage sort Iterator
				_self.ownedSource.generate(context)
			}
			
			case "closure":{
				//Todo refactor it in a generic way, with lambda
				//Fix bad function call ...
				val type = _self.ownedIterators.get(0).type.name
				
				val closureStaticFunctionName = type+"Closure"+context.globalContext.getNextVar()
				context.globalContext.staticMethods.putIfAbsent(closureStaticFunctionName,
				'''
				
				 public static Set<«type»> «closureStaticFunctionName»(Set<«type»> param ){
				 		Stack<«type»> stack = new Stack<>();
				 		HashSet<«type»> res = new HashSet<>();
				 		stack.addAll(param);
				 		res.addAll(param);
				 		
				 		while(!stack.isEmpty()){
				 			        Set<«type»> children= new HashSet<«type»>();
				 					
				 		            «type» «c.iteratorVariable»=stack.pop();
				 		            try{
				 		            «IF !(_self.ownedBody.type instanceof CollectionType) »
				 		            children= new HashSet<«type»>(Arrays.asList(«_self.ownedBody.generate(c)»));
				 		            «ELSE»
				 		            children= «_self.ownedBody.generate(c)»;		 		            
				 		            «ENDIF»
				 		            }catch(Exception e){
				 		            	logger.warn("Error during closure for"+ param);
				 		           		logger.debug("Error during closure for"+ param,e);
				 		            }
				 		            for(«type» child: children){
				 		                if(child!=null && !res.contains(child)){
				 		                    res.add(child);
				 		                    stack.add(child);
				 		                }
				 		            }
				 		
				 		        }
				 		        return res;
				 		 }
				''')
				
				'''
				«closureStaticFunctionName»(«propertyToSearchIn».stream().collect(Collectors.toSet()))
				'''
			}case 'collect':{
				//Todo Handle all cases
				if(_self.ownedSource.type instanceof CollectionType && _self.ownedBody.name=="oclAsSet"){
					'''
					«_self.ownedSource.generate(context)».stream().collect(Collectors.toSet())
					'''
				}
			}
		}
	}
}

@Aspect(className=TypeExp)
class TypeExpAspect extends OCLExpressionAspect {
	/*
	* BE CAREFUL :
	*
	* This class has more than one superclass
	* please specify which parent you want with the 'super' expected calling
	*
	*/
	def String generate(Context context){
		'''«_self.name»'''
	}

}
	
	

