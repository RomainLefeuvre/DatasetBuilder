package fr.inria.diverse.swhModel.generator.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.eclipse.ocl.pivot.Annotation
import org.eclipse.ocl.pivot.AnyType
import org.eclipse.ocl.pivot.AssociationClass
import org.eclipse.ocl.pivot.AssociationClassCallExp
import org.eclipse.ocl.pivot.BagType
import org.eclipse.ocl.pivot.Behavior
import org.eclipse.ocl.pivot.BooleanLiteralExp
import org.eclipse.ocl.pivot.CallExp
import org.eclipse.ocl.pivot.CallOperationAction
import org.eclipse.ocl.pivot.Class
import org.eclipse.ocl.pivot.CollectionItem
import org.eclipse.ocl.pivot.CollectionLiteralExp
import org.eclipse.ocl.pivot.CollectionLiteralPart
import org.eclipse.ocl.pivot.CollectionRange
import org.eclipse.ocl.pivot.CollectionType
import org.eclipse.ocl.pivot.Comment
import org.eclipse.ocl.pivot.CompleteClass
import org.eclipse.ocl.pivot.CompleteEnvironment
import org.eclipse.ocl.pivot.CompleteModel
import org.eclipse.ocl.pivot.CompletePackage
import org.eclipse.ocl.pivot.ConnectionPointReference
import org.eclipse.ocl.pivot.Constraint
import org.eclipse.ocl.pivot.DataType
import org.eclipse.ocl.pivot.Detail
import org.eclipse.ocl.pivot.DynamicBehavior
import org.eclipse.ocl.pivot.DynamicElement
import org.eclipse.ocl.pivot.DynamicProperty
import org.eclipse.ocl.pivot.DynamicType
import org.eclipse.ocl.pivot.DynamicValueSpecification
import org.eclipse.ocl.pivot.Element
import org.eclipse.ocl.pivot.ElementExtension
import org.eclipse.ocl.pivot.EnumLiteralExp
import org.eclipse.ocl.pivot.Enumeration
import org.eclipse.ocl.pivot.EnumerationLiteral
import org.eclipse.ocl.pivot.ExpressionInOCL
import org.eclipse.ocl.pivot.Feature
import org.eclipse.ocl.pivot.FeatureCallExp
import org.eclipse.ocl.pivot.FinalState
import org.eclipse.ocl.pivot.IfExp
import org.eclipse.ocl.pivot.Import
import org.eclipse.ocl.pivot.InstanceSpecification
import org.eclipse.ocl.pivot.IntegerLiteralExp
import org.eclipse.ocl.pivot.InvalidLiteralExp
import org.eclipse.ocl.pivot.InvalidType
import org.eclipse.ocl.pivot.IterableType
import org.eclipse.ocl.pivot.IterateExp
import org.eclipse.ocl.pivot.Iteration
import org.eclipse.ocl.pivot.IteratorExp
import org.eclipse.ocl.pivot.IteratorVariable
import org.eclipse.ocl.pivot.LambdaType
import org.eclipse.ocl.pivot.LanguageExpression
import org.eclipse.ocl.pivot.LetExp
import org.eclipse.ocl.pivot.LetVariable
import org.eclipse.ocl.pivot.Library
import org.eclipse.ocl.pivot.LiteralExp
import org.eclipse.ocl.pivot.LoopExp
import org.eclipse.ocl.pivot.MapLiteralExp
import org.eclipse.ocl.pivot.MapLiteralPart
import org.eclipse.ocl.pivot.MapType
import org.eclipse.ocl.pivot.MessageExp
import org.eclipse.ocl.pivot.MessageType
import org.eclipse.ocl.pivot.Model
import org.eclipse.ocl.pivot.NamedElement
import org.eclipse.ocl.pivot.Namespace
import org.eclipse.ocl.pivot.NavigationCallExp
import org.eclipse.ocl.pivot.NullLiteralExp
import org.eclipse.ocl.pivot.NumericLiteralExp
import org.eclipse.ocl.pivot.OCLExpression
import org.eclipse.ocl.pivot.Operation
import org.eclipse.ocl.pivot.OperationCallExp
import org.eclipse.ocl.pivot.OppositePropertyCallExp
import org.eclipse.ocl.pivot.OrderedSetType
import org.eclipse.ocl.pivot.OrphanCompletePackage
import org.eclipse.ocl.pivot.Package
import org.eclipse.ocl.pivot.Parameter
import org.eclipse.ocl.pivot.ParameterVariable
import org.eclipse.ocl.pivot.Precedence
import org.eclipse.ocl.pivot.PrimitiveCompletePackage
import org.eclipse.ocl.pivot.PrimitiveLiteralExp
import org.eclipse.ocl.pivot.PrimitiveType
import org.eclipse.ocl.pivot.Profile
import org.eclipse.ocl.pivot.ProfileApplication
import org.eclipse.ocl.pivot.Property
import org.eclipse.ocl.pivot.PropertyCallExp
import org.eclipse.ocl.pivot.Pseudostate
import org.eclipse.ocl.pivot.RealLiteralExp
import org.eclipse.ocl.pivot.ReferringElement
import org.eclipse.ocl.pivot.Region
import org.eclipse.ocl.pivot.ResultVariable
import org.eclipse.ocl.pivot.SelfType
import org.eclipse.ocl.pivot.SendSignalAction
import org.eclipse.ocl.pivot.SequenceType
import org.eclipse.ocl.pivot.SetType
import org.eclipse.ocl.pivot.ShadowExp
import org.eclipse.ocl.pivot.ShadowPart
import org.eclipse.ocl.pivot.Signal
import org.eclipse.ocl.pivot.Slot
import org.eclipse.ocl.pivot.StandardLibrary
import org.eclipse.ocl.pivot.State
import org.eclipse.ocl.pivot.StateExp
import org.eclipse.ocl.pivot.StateMachine
import org.eclipse.ocl.pivot.Stereotype
import org.eclipse.ocl.pivot.StereotypeExtender
import org.eclipse.ocl.pivot.StringLiteralExp
import org.eclipse.ocl.pivot.TemplateBinding
import org.eclipse.ocl.pivot.TemplateParameter
import org.eclipse.ocl.pivot.TemplateParameterSubstitution
import org.eclipse.ocl.pivot.TemplateSignature
import org.eclipse.ocl.pivot.TemplateableElement
import org.eclipse.ocl.pivot.Transition
import org.eclipse.ocl.pivot.Trigger
import org.eclipse.ocl.pivot.TupleLiteralExp
import org.eclipse.ocl.pivot.TupleLiteralPart
import org.eclipse.ocl.pivot.TupleType
import org.eclipse.ocl.pivot.Type
import org.eclipse.ocl.pivot.TypeExp
import org.eclipse.ocl.pivot.TypedElement
import org.eclipse.ocl.pivot.UnlimitedNaturalLiteralExp
import org.eclipse.ocl.pivot.UnspecifiedValueExp
import org.eclipse.ocl.pivot.ValueSpecification
import org.eclipse.ocl.pivot.Variable
import org.eclipse.ocl.pivot.VariableDeclaration
import org.eclipse.ocl.pivot.VariableExp
import org.eclipse.ocl.pivot.Vertex
import org.eclipse.ocl.pivot.VoidType
import org.eclipse.ocl.pivot.WildcardType

import static extension fr.inria.diverse.swhModel.generator.aspects.AnnotationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.AnyTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.AssociationClassAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.AssociationClassCallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.BagTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.BehaviorAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.BooleanLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CallOperationActionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ClassAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CollectionItemAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CollectionLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CollectionLiteralPartAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CollectionRangeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CollectionTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CommentAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CompleteClassAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CompleteEnvironmentAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CompleteModelAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.CompletePackageAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ConnectionPointReferenceAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ConstraintAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DataTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DetailAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DynamicBehaviorAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DynamicElementAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DynamicPropertyAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DynamicTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.DynamicValueSpecificationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ElementAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ElementExtensionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.EnumLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.EnumerationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.EnumerationLiteralAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ExpressionInOCLAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.FeatureAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.FeatureCallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.FinalStateAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IfExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ImportAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.InstanceSpecificationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IntegerLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.InvalidLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.InvalidTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IterableTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IterateExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IterationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.IteratorVariableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LambdaTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LanguageExpressionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LetExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LetVariableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LibraryAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.LoopExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.MapLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.MapLiteralPartAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.MapTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.MessageExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.MessageTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.Pivot_ModelAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.MorePivotableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.NameableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.NamedElementAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.NamespaceAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.NavigationCallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.NullLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.NumericLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.OCLExpressionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.OperationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.OperationCallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.OppositePropertyCallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.OrderedSetTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.OrphanCompletePackageAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PackageAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ParameterAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ParameterVariableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PivotableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PrecedenceAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PrimitiveCompletePackageAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PrimitiveLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PrimitiveTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ProfileAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ProfileApplicationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PropertyAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PropertyCallExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.PseudostateAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.RealLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ReferringElementAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.RegionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ResultVariableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.SelfTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.SendSignalActionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.SequenceTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.SetTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ShadowExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ShadowPartAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.SignalAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.SlotAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StandardLibraryAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StateAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StateExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StateMachineAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StereotypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StereotypeExtenderAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.StringLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TemplateBindingAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TemplateParameterAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TemplateParameterSubstitutionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TemplateSignatureAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TemplateableElementAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TransitionAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TriggerAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TupleLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TupleLiteralPartAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TupleTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.TypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.UnlimitedNaturalLiteralExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.UnspecifiedValueExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.ValueSpecificationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.VariableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.VariableDeclarationAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.VariableExpAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.VertexAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.VisitableAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.VoidTypeAspect.*
import static extension fr.inria.diverse.swhModel.generator.aspects.WildcardTypeAspect.*
import org.eclipse.ocl.pivot.utilities.MorePivotable
import org.eclipse.ocl.pivot.utilities.Nameable
import org.eclipse.ocl.pivot.utilities.Pivotable
import org.eclipse.ocl.utilities.Visitable
import org.eclipse.ocl.pivot.internal.OperationImpl
import org.eclipse.ocl.expressions.impl.OCLExpressionImpl
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.HashMap
import java.util.UUID

@Aspect(className=Model)
class Pivot_ModelAspect extends NamespaceAspect {
	def String generate(String queryId) {
		'''
			«_self.ownedPackages.get(0).generate(queryId)»
		'''
	}
}

@Aspect(className=Package)
class PackageAspect extends NamespaceAspect {
	def String generate(String queryId) {
		val Context c = new Context()
		'''
			package fr.inria.diverse.query;
			import fr.inria.diverse.*;
			import fr.inria.diverse.model.*;
			import fr.inria.diverse.tools.*;
			import org.apache.logging.log4j.LogManager;
			import org.apache.logging.log4j.Logger;
			import org.softwareheritage.graph.SwhType;
			import org.softwareheritage.graph.SwhUnidirectionalGraph;
			import java.io.IOException;
			import java.util.stream.Collectors;
			import java.util.*;
			
			public class GraphQuery implements IGraphQuery{
			    static Logger logger = LogManager.getLogger(GraphQuery.class);
			    static String id = "«queryId»";
			    private Graph g;		    
			
			    public GraphQuery() throws IOException {
			        g = new Graph();
			        g.init();
			    }
					
				«FOR ownedClass : _self.ownedClasses»  
					«IF !ownedClass.name.equals("Graph")»
						«ownedClass.generate(c)»
					«ENDIF»
				«ENDFOR»
				«FOR ownedClass : _self.ownedClasses»  
					«IF ownedClass.name.equals("Graph")»
						«ownedClass.generate(c)»
					«ENDIF»
				«ENDFOR»				
				«FOR staticMethod : c.globalContext.staticMethods.values»
					«staticMethod»
				«ENDFOR»
			}
		'''
	}
}

@Aspect(className=Class)
class ClassAspect extends TypeAspect {
	def String generate(Context c) {
		'''
			«FOR operation : _self.ownedOperations»        
				«operation.generate(c.clone)»
			«ENDFOR»
		'''
	}

}

//Todo Handle operation with parameter and handle Type properly
@Aspect(className=Operation)
class OperationAspect extends FeatureAspect {
	def String generate(Context context) {
		context.currentClass = _self.owningClass.name
		// val test = _self.own
		switch _self.name {
			case 'query': {
				'''
					public Set<Long> runQuery() throws IOException, InterruptedException {
						Set<Long> results = new HashSet<>();
						logger.info("------Executing query "+id+"------");
						«_self.bodyExpression.generate(context)»
						return results;			    
					}
				'''
			}
			default: {
				context.globalContext.contextMethods.put(_self.name, _self.owningClass.name);
				'''
					public static «_self.type.name» «_self.name»( «_self.owningClass.name» self){
						return 	«_self.bodyExpression.generate(context)»;
						
					} 
				'''
			}
		}
	}

}

@Aspect(className=ExpressionInOCL)
class ExpressionInOCLAspect extends LanguageExpressionAspect {
	def String generate(Context c) {
		return _self.ownedBody.generate(c)
	}
}

@Aspect(className=LanguageExpression)
abstract class LanguageExpressionAspect extends ValueSpecificationAspect {
	def String generate(Context c) {
	}

}

@Aspect(className=OCLExpression)
abstract class OCLExpressionAspect extends TypedElementAspect {
	def String generate(Context context) {
		throw new Exception("Not implemented ")
	}
}

@Aspect(className=PropertyCallExp)
class PropertyCallExpAspect extends NavigationCallExpAspect {
	def String generate(Context context) {
		val sourceAttribute = _self.ownedSource.generate(context)

		val getter = "get" + _self.name.toFirstUpper + "()"
		switch sourceAttribute {
			case 'self': {
				if(context.currentClass.equals("Graph")){
				'''this.g.«getter»'''
				}else{
				'''«sourceAttribute».«getter»'''
				}
			}
			case '1_': {
				// If we got '1_' we suppose that it refer to the iterator variable
				// Let's take as source the closer iterator variable saved in the context
				'''«context.iteratorVariable».«getter»'''
			}
			default: {
				'''«sourceAttribute».«getter»'''
			}
		}
	}

}

@Aspect(className=VariableExp)
class VariableExpAspect extends OCLExpressionAspect {
	def String generate(Context context) {
		switch (_self.name) {
			case '1_': context.iteratorVariable
			default: _self.name
		}
	}

}

@Aspect(className=OperationCallExp)
class OperationCallExpAspect extends FeatureCallExpAspect {
	def String generate(Context context) {
		val source = _self.ownedSource.generate(context)
		switch (_self.name) {
			case 'oclAsSet': {
				'''(new HashSet<«_self.ownedSource.type.name»>(Arrays.asList(«source»)))'''
			}
			case 'asSet': {
				'''(new HashSet<«_self.ownedSource.type.name»>(Arrays.asList(«source»)))'''
			}
			case 'oclIsKindOf': {
				'''(«source» instanceof «_self.ownedArguments.get(0).generate(context)»)'''
			}
			case 'oclAsType': {
				'''((«_self.ownedArguments.get(0).generate(context)») «source»)'''

			}
			case 'first': {
				'''«source».get(0)'''
			}
			case '=': {
				val value = _self.ownedArguments.get(0) as OCLExpression
				'''«source».equals(«value.generate(context)»)'''
			}
			case '>': {
				val value = _self.ownedArguments.get(0) as OCLExpression
				'''«source» > («value.generate(context)»)'''
			}
			case '<': {
				val value = _self.ownedArguments.get(0) as OCLExpression
				'''«source» < («value.generate(context)»)'''
			}
			case 'or': {
				val value = _self.ownedArguments.get(0) as OCLExpression
				'''
					(«source» || 
						«value.generate(context)»)
					             '''
			}
			case 'and': {
				val value = _self.ownedArguments.get(0) as OCLExpression
				'''
					(«source» && 
						«value.generate(context)»)
					             '''
			}
			default: {
				// Function call
				//Todo Handle multiple argument
				if (context.globalContext.contextMethods.containsKey(_self.name)) {
					switch (_self.ownedArguments.size) {
						case 0: '''«_self.name»(«source»)'''
						case 1: {
							val value = _self.ownedArguments.get(0) as OCLExpression
							'''«_self.name» («source» ,«value.generate(context)»)'''
						}
					}

				} else {
					switch (_self.ownedArguments.size) {
						case 0: '''«source».«_self.name»()'''
						case 1: {
							val value = _self.ownedArguments.get(0) as OCLExpression
							'''«source» «_self.name» («value.generate(context)»)'''
						}
					}
				}
			}
		}
	}
}

@Aspect(className=NullLiteralExp)
class NullLiteralExpAspect extends PrimitiveLiteralExpAspect {
	def String generate(Context context){
		return "null"
	}
}

@Aspect(className=ParameterVariable)
class ParameterVariableAspect extends VariableAspect {
	def String generate(Context context) {
	}

}

@Aspect(className=StringLiteralExp)
class StringLiteralExpAspect extends PrimitiveLiteralExpAspect {
	def String generate(Context context) {
		'''"«_self.stringSymbol»"'''
	}
}

@Aspect(className=IntegerLiteralExp)
class IntegerLiteralExpAspect extends NumericLiteralExpAspect {
	def String generate(Context context) {
		'''«_self.integerSymbol»'''
	}
}

@Aspect(className=BooleanLiteralExp)
class BooleanLiteralExpAspect extends PrimitiveLiteralExpAspect {
	def String generate(Context context) {
		'''"'''
	}
}

@Aspect(className=Annotation)
class AnnotationAspect extends NamedElementAspect {
}

@Aspect(className=AnyType)
class AnyTypeAspect extends ClassAspect {
}

@Aspect(className=AssociationClass)
class AssociationClassAspect extends ClassAspect {
}

@Aspect(className=AssociationClassCallExp)
class AssociationClassCallExpAspect extends NavigationCallExpAspect {
}

@Aspect(className=BagType)
class BagTypeAspect extends CollectionTypeAspect {
}

@Aspect(className=Behavior)
abstract class BehaviorAspect extends ClassAspect {
}

@Aspect(className=CallExp)
abstract class CallExpAspect extends OCLExpressionAspect {
}

@Aspect(className=CallOperationAction)
class CallOperationActionAspect extends NamedElementAspect {
}

@Aspect(className=CollectionItem)
class CollectionItemAspect extends CollectionLiteralPartAspect {
}

@Aspect(className=CollectionLiteralExp)
class CollectionLiteralExpAspect extends LiteralExpAspect {
}

@Aspect(className=CollectionLiteralPart)
abstract class CollectionLiteralPartAspect extends TypedElementAspect {
}

@Aspect(className=CollectionRange)
class CollectionRangeAspect extends CollectionLiteralPartAspect {
}

@Aspect(className=CollectionType)
class CollectionTypeAspect extends IterableTypeAspect {
}

@Aspect(className=Comment)
class CommentAspect extends ElementAspect {
}

@Aspect(className=CompleteClass)
class CompleteClassAspect extends NamedElementAspect {
}

@Aspect(className=CompleteEnvironment)
class CompleteEnvironmentAspect extends ElementAspect {
}

@Aspect(className=CompleteModel)
class CompleteModelAspect extends NamedElementAspect {
}

@Aspect(className=CompletePackage)
class CompletePackageAspect extends NamedElementAspect {
}

@Aspect(className=ConnectionPointReference)
class ConnectionPointReferenceAspect extends VertexAspect {
}

@Aspect(className=Constraint)
class ConstraintAspect extends NamedElementAspect {
}

@Aspect(className=DataType)
class DataTypeAspect extends ClassAspect {
}

@Aspect(className=Detail)
class DetailAspect extends NamedElementAspect {
}

@Aspect(className=DynamicBehavior)
class DynamicBehaviorAspect extends BehaviorAspect {
}

@Aspect(className=DynamicElement)
class DynamicElementAspect extends ElementAspect {
}

@Aspect(className=DynamicProperty)
class DynamicPropertyAspect extends ElementAspect {
}

@Aspect(className=DynamicType)
class DynamicTypeAspect extends ClassAspect {
}

@Aspect(className=DynamicValueSpecification)
class DynamicValueSpecificationAspect extends ValueSpecificationAspect {
}

@Aspect(className=Element)
abstract class ElementAspect {
}

@Aspect(className=ElementExtension)
class ElementExtensionAspect extends ClassAspect {
}

@Aspect(className=EnumLiteralExp)
class EnumLiteralExpAspect extends LiteralExpAspect {
}

@Aspect(className=Enumeration)
class EnumerationAspect extends DataTypeAspect {
}

@Aspect(className=EnumerationLiteral)
class EnumerationLiteralAspect extends InstanceSpecificationAspect {
}

@Aspect(className=Feature)
abstract class FeatureAspect extends TypedElementAspect {
}

@Aspect(className=FeatureCallExp)
abstract class FeatureCallExpAspect extends CallExpAspect {
}

@Aspect(className=FinalState)
class FinalStateAspect extends StateAspect {
}

@Aspect(className=Import)
class ImportAspect extends NamedElementAspect {
}

@Aspect(className=InstanceSpecification)
class InstanceSpecificationAspect extends NamedElementAspect {
}

@Aspect(className=InvalidLiteralExp)
class InvalidLiteralExpAspect extends LiteralExpAspect {
}

@Aspect(className=InvalidType)
class InvalidTypeAspect extends ClassAspect {
}

@Aspect(className=IterableType)
abstract class IterableTypeAspect extends DataTypeAspect {
}

@Aspect(className=IterateExp)
class IterateExpAspect extends LoopExpAspect {
}

@Aspect(className=Iteration)
class IterationAspect extends OperationAspect {
}

@Aspect(className=IteratorVariable)
class IteratorVariableAspect extends VariableAspect {
}

@Aspect(className=LambdaType)
class LambdaTypeAspect extends DataTypeAspect {
}

@Aspect(className=LetExp)
class LetExpAspect extends OCLExpressionAspect {
}

@Aspect(className=LetVariable)
class LetVariableAspect extends VariableAspect {
}

@Aspect(className=Library)
class LibraryAspect extends PackageAspect {
}

@Aspect(className=LiteralExp)
abstract class LiteralExpAspect extends OCLExpressionAspect {
	def String generate(Context context) {
		return _self.name
	}

}

@Aspect(className=LoopExp)
abstract class LoopExpAspect extends CallExpAspect {
}

@Aspect(className=MapLiteralExp)
class MapLiteralExpAspect extends LiteralExpAspect {
}

@Aspect(className=MapLiteralPart)
class MapLiteralPartAspect extends ElementAspect {
}

@Aspect(className=MapType)
class MapTypeAspect extends IterableTypeAspect {
}

@Aspect(className=MessageExp)
class MessageExpAspect extends OCLExpressionAspect {
}

@Aspect(className=MessageType)
class MessageTypeAspect extends ClassAspect {
}

@Aspect(className=MorePivotable)
abstract class MorePivotableAspect {
}

@Aspect(className=Nameable)
abstract class NameableAspect {
}

@Aspect(className=NamedElement)
abstract class NamedElementAspect extends ElementAspect {
}

@Aspect(className=Namespace)
abstract class NamespaceAspect extends NamedElementAspect {
}

@Aspect(className=NavigationCallExp)
abstract class NavigationCallExpAspect extends FeatureCallExpAspect {
}



@Aspect(className=NumericLiteralExp)
abstract class NumericLiteralExpAspect extends PrimitiveLiteralExpAspect {
}

@Aspect(className=OppositePropertyCallExp)
class OppositePropertyCallExpAspect extends NavigationCallExpAspect {
}

@Aspect(className=OrderedSetType)
class OrderedSetTypeAspect extends CollectionTypeAspect {
}

@Aspect(className=OrphanCompletePackage)
class OrphanCompletePackageAspect extends CompletePackageAspect {
}

@Aspect(className=Parameter)
class ParameterAspect extends VariableDeclarationAspect {
}

@Aspect(className=Pivotable)
abstract class PivotableAspect {
}

@Aspect(className=Precedence)
class PrecedenceAspect extends NamedElementAspect {
}

@Aspect(className=PrimitiveCompletePackage)
class PrimitiveCompletePackageAspect extends CompletePackageAspect {
}

@Aspect(className=PrimitiveLiteralExp)
abstract class PrimitiveLiteralExpAspect extends LiteralExpAspect {
	def String generate(Context context) {		
		return _self.name
	}
}

@Aspect(className=PrimitiveType)
class PrimitiveTypeAspect extends DataTypeAspect {
}

@Aspect(className=Profile)
class ProfileAspect extends PackageAspect {
}

@Aspect(className=ProfileApplication)
class ProfileApplicationAspect extends ElementAspect {
}

@Aspect(className=Property)
class PropertyAspect extends FeatureAspect {
}

@Aspect(className=Pseudostate)
class PseudostateAspect extends VertexAspect {
}

@Aspect(className=RealLiteralExp)
class RealLiteralExpAspect extends NumericLiteralExpAspect {
}

@Aspect(className=ReferringElement)
abstract class ReferringElementAspect {
}

@Aspect(className=Region)
class RegionAspect extends NamespaceAspect {
}

@Aspect(className=ResultVariable)
class ResultVariableAspect extends VariableAspect {
}

@Aspect(className=SelfType)
class SelfTypeAspect extends ClassAspect {
}

@Aspect(className=SendSignalAction)
class SendSignalActionAspect extends NamedElementAspect {
}

@Aspect(className=SequenceType)
class SequenceTypeAspect extends CollectionTypeAspect {
}

@Aspect(className=SetType)
class SetTypeAspect extends CollectionTypeAspect {
}

@Aspect(className=ShadowExp)
class ShadowExpAspect extends OCLExpressionAspect {
}

@Aspect(className=ShadowPart)
class ShadowPartAspect extends TypedElementAspect {
}

@Aspect(className=Signal)
class SignalAspect extends ClassAspect {
}

@Aspect(className=Slot)
class SlotAspect extends ElementAspect {
}

@Aspect(className=StandardLibrary)
class StandardLibraryAspect extends ElementAspect {
}

@Aspect(className=State)
class StateAspect extends NamespaceAspect {
}

@Aspect(className=StateExp)
class StateExpAspect extends OCLExpressionAspect {
}

@Aspect(className=StateMachine)
class StateMachineAspect extends BehaviorAspect {
}

@Aspect(className=Stereotype)
class StereotypeAspect extends ClassAspect {
}

@Aspect(className=StereotypeExtender)
class StereotypeExtenderAspect extends ElementAspect {
}

@Aspect(className=TemplateBinding)
class TemplateBindingAspect extends ElementAspect {
}

@Aspect(className=TemplateParameter)
class TemplateParameterAspect extends TypeAspect {
}

@Aspect(className=TemplateParameterSubstitution)
class TemplateParameterSubstitutionAspect extends ElementAspect {
}

@Aspect(className=TemplateSignature)
class TemplateSignatureAspect extends ElementAspect {
}

@Aspect(className=TemplateableElement)
abstract class TemplateableElementAspect extends ElementAspect {
}

@Aspect(className=Transition)
class TransitionAspect extends NamespaceAspect {
}

@Aspect(className=Trigger)
class TriggerAspect extends NamedElementAspect {
}

@Aspect(className=TupleLiteralExp)
class TupleLiteralExpAspect extends LiteralExpAspect {
}

@Aspect(className=TupleLiteralPart)
class TupleLiteralPartAspect extends VariableDeclarationAspect {
}

@Aspect(className=TupleType)
class TupleTypeAspect extends DataTypeAspect {
}

@Aspect(className=Type)
abstract class TypeAspect extends NamedElementAspect {
}

@Aspect(className=TypedElement)
abstract class TypedElementAspect extends NamedElementAspect {
}

@Aspect(className=UnlimitedNaturalLiteralExp)
class UnlimitedNaturalLiteralExpAspect extends NumericLiteralExpAspect {
}

@Aspect(className=UnspecifiedValueExp)
class UnspecifiedValueExpAspect extends OCLExpressionAspect {
}

@Aspect(className=ValueSpecification)
abstract class ValueSpecificationAspect extends TypedElementAspect {
}

@Aspect(className=Variable)
class VariableAspect extends VariableDeclarationAspect {
}

@Aspect(className=VariableDeclaration)
abstract class VariableDeclarationAspect extends TypedElementAspect {
}

@Aspect(className=Vertex)
abstract class VertexAspect extends NamedElementAspect {
}

@Aspect(className=Visitable)
abstract class VisitableAspect {
}

@Aspect(className=VoidType)
class VoidTypeAspect extends ClassAspect {
}

@Aspect(className=WildcardType)
class WildcardTypeAspect extends ClassAspect {
}

@Accessors
class Context {
	// Todo split into two contexts,commun at all context
	String returnVariable
	String returnType
	String indent
	String iteratorVariable
	String currentClass
	GlobalContext globalContext

	new(String indent) {
		this.indent = indent

	}

	new() {
		this.indent = ""
		this.globalContext = new GlobalContext()

	}

	def Context addIndentAndCopy(String indentToAdd) {
		val result = new Context(this.indent + indentToAdd)
		result.iteratorVariable = this.iteratorVariable
		return result;
	}

	/*
	 * Clone all attribute except static methods
	 */
	override Context clone() {
		val context = new Context(this.indent)
		context.iteratorVariable = this.iteratorVariable
		context.globalContext = this.globalContext
		context.returnType = this.returnType
		context.returnVariable = this.returnVariable
		context.currentClass = this.currentClass
		return context
	}

}

@Accessors
class GlobalContext {
	// Name,code
	HashMap<String, String> staticMethods
	// Name, Class name
	HashMap<String, String> contextMethods
	int varIndex;

	new() {
		this.staticMethods = new HashMap<String, String>()
		this.contextMethods = new HashMap<String, String>()
		this.varIndex = 0;
	}

	def int getNextVar() {
		varIndex++
		varIndex
	}
}
