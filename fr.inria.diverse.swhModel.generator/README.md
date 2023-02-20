The generator can be used through the jar package version : ```fr.inria.diverse.swhModel.generator/fr.inria.diverse.swhModel_0.1.0.jar ``` : 
* run ```java -jar fr.inria.diverse.swhModel.generator/fr.inria.diverse.swhModel_0.1.0.jar <oclModelPath> <exportPath> <QueryName>``` where 
  * ```<oclModelPath>``` the path of the ocl model (either .ocl or the abstract syntax saved in .oclas)
  * ```<exportPath>``` the path were the resulting java code will be saved
  * ```<QueryId>``` the query Id, used for saving the query results during execution

Exemple : **```java -jar fr.inria.diverse.swhModel_0.1.0.jar tests/resources/swhModelQuery_01/swhModelQuery.ocl ./query.java testQuery```**

Note : only the java class is generate, use the script oclCompilerLauncher.sh to compile, copy this class to the fingerprint project and then produce a jar that will allow you to execute your query over the property graph dataset.