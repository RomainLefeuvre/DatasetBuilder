
<a name="readme-top"></a>





[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN">
    <!--img src="images/logo.png" alt="Logo" width="80" height="80"-->
  </a>

<h3 align="center">DATASET BUILDER</h3>

  <p align="center">
    Build repository dataset by describing an OCL query on the SoftwareHeritage Graph Property Dataset
    <br />
    <a href="https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN">View Demo</a>
    ·
    <a href="https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/issues">Report Bug</a>
    ·
    <a href="https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#tutorial">Tutorial</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
This project is a companion repository containing a prototype of the fingerprint approach. We mention that it's a prototype since we do not guaranty any usage different than those describe in the paper. For instance the compiler do not handle all the expressivity of OCL, only the ocl concepts present on the running query are implemented. Moreover a more advanced test coverage is required to use it at large scale. 

### Structure 
* ```fr.inria.diverse.swhModel``` : The project containing the object oriented model of the SWH graph dataset expressed as an ecore project
* ```fr.inria.diverse.swhModel.generator``` : The project containing the generator, it generate java code that target the swh-graph api from a query expressed in OCL on the OO model.
* ```fr.inria.diverse.swhModel.fingerprint``` : The project that exposes an OO oriented api of the swh-graph, allowing to execute query on an export of the property graph dataset. 
* ```fr.inria.diverse.swhModel.generator.tests``` : The project containing the tests of the generator
* ```fr.inria.diverse.swhModel.queryExemple``` : An example project containing ocl query template. It can be used to design OCL query while leveraging on OCL tooling.
* ```thirdPartyLibrary``` : The third party libraries that are not available on maven central, for most of the library used by the generator are in the eclipse ecosystem and not available in m2 repo.
* ```result``` : The experiments of the results described in the paper, NB the log cannot be loaded in this repos since they are really huge (tens of Go), if you need it do not hesitate to e-mail me. For each fingerprint run you will find a json listing the different origin id matching the query. You can easily use it to extract metadata relative to those repository in the corresponding export. You can also extract a subdataset of the swh-graph property dataset in order to distribute it and allow your user to exploit your dataset in a laptop !
<!--([![Product Name Screen Shot][product-screenshot]](https://example.com)-->



<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- GETTING STARTED -->
## Prerequisites
* Java 11
* (Maven : we use maven wrapper such that it's not mandatory to have mave install in you machine, facilating reproducibility)
* launch ./install.sh script to install custom the swh-graph fork we use 
  
### Build Prerequisites
* Ant >= 1.10.12
* Linux
### Tooling Prerequisites (Optional for ocl query editor support)
* [GemocStudio V3.5.0](https://gemoc.org/download.html)

## Usage
## Context
The fingerprint approach is decompose in two part, a query describe in ocl and a timestamp, generally the version of the property graph dataset you will execute on it. 𝐹𝑃tx = ⟨𝑡x, 𝑞⟩. A run of a fingerprint is describe as  FPtx X Gx.

The prototype is decompose also in 3 steps :
* 1- Designing your ocl query over the OO model of the swh property dataset (cf figure 2 in the paper), or use our running query
* 2- Compile your query in java code that leverage on the swh-graph api
* 3- Execute your code and get the repositories that match your query (You will need to download the dataset )
###  Usage
#### Compile your ocl query
The generator can be used through oclQueryCompilerLaucher.sh script that automate the call of the generator and the copy/paste of the resulting java file to the fingerprint projet. In output you will obtain a fat jar of the fingerprint project containing your query :
* be sure to have run ```sh ./install.sh``` to install the forked version of swh-graph
* run ```sh oclQueryCompilerLaucher.sh <oclModelPath>  <QueryName> <exportPath>``` where 
  * ```<oclModelPath>``` the path of the ocl model (either .ocl or the abstract syntax saved in .oclas)
  * ```<QueryId>``` the query Id, used for saving the query results during execution
  *  ```<exportPath>``` the path were the resulting java code will be saved

Exemple : **```sh oclQueryCompilerLauncher.sh ./result/swhModelQuery.ocl RUNNING_QUERY ./result```**

#### Execute the resulting jar to run your query on the swh graph property dataset 
##### Requirement :
* At least 500 GB of ram + 4to ssd
* Download a version of the property graph dataset (https://docs.softwareheritage.org/devel/swh-dataset/graph/dataset.html), you can create leverage on the ```result/dl_script.sh```  (run it from the result folder)
* To obtain better result mount a tmpfs and put it the graph.graph file that you will symlink to the dataset/your_graph/compressed folder
* Display help :
```java  -jar ./result/fr.inria.diverse.fingerprint-0.1.0.jar --help```
``` 
[picocli WARN] defaults configuration file /home/rlefeuvr/Workspaces/SAND_BOX/SW_GRAPH/OCL_PROJECT/./config/config.properties does not exist or is not readable
Usage: GraphQueryRunner [-h] [-c=<checkPointIntervalInMinutes>]
                        [-e=<exportPath>] -g=<graphFolderPath>
                        [-l=<loadingMode>] [-qt=<queryTimestamp>]
                        [-t=<threadNumber>]
Execute a query over the graph property dataset
  -c, --checkPointIntervalInMinutes=<checkPointIntervalInMinutes>
               The time in minutes after which a checkpoint will be produced
  -e, --exportPath=<exportPath>
               The export path, where all the queries results will be saved
                 including checkpoints
  -g, --graphPath=<graphFolderPath>
               The graph Folder path
  -h, --help   display this help and exit
  -l, --loadingMode=<loadingMode>
               The graph loading mode either MAPPED for memory mapped or RAM
                 for ram loading
      -qt, --queryTimestamp=<queryTimestamp>
               The  query Timestamp
  -t, --threadNumber=<threadNumber>
               The number of thread the query will use
Romain Lefeuvre - DIVERSE team - Inria
```
* Run command Exemple: 
```
java -ea -server -XX:PretenureSizeThreshold=512M -XX:MaxNewSize=4G -XX:+UseLargePages -XX:+UseTransparentHugePages -XX:+UseNUMA -XX:+UseTLAB -XX:+ResizeTLAB -Djava.io.tmpdir=../java-tmp-dir -Xmx600G --add-opens=java.base/sun.nio.ch=ALL-UNNAMED -jar ./result/fr.inria.diverse.fingerprint-0.1.0.jar --exportPath=./result/export/2022-04-24 --threadNumber=60 --queryTimestamp=2022-04-24 --graphPath=./result/graph/2022-04-25 --checkPointIntervalInMinutes=300

 ```

### Designing ocl queries
Queries are described as an OCL Operation named ”query” in the Graph context, returning a Set of Origin i.e. the set of repository matching the query. The following template can be used :
```
import swhModel : 'platform:/resource/fr.inria.diverse.swhModel/model/swhModel.ecore'
package swhModel
context Graph
def : query():Set(Origin) = origins->select(
	/*QUERY BODY */
)
endpackage
```


To define the ocl request and therefore the input model of the generator, it is recommended to use the eclipse tooling providing development tools for OCL.
* Install the Gemoc GemocStudio
* Import the ```fr.inria.diverse.swhModel project``` and ```fr.inria.diverse.swhModel.queryExemple``` projects
* Modify the templace.ocl file 
* Use the previous section (Standelone Usage) to generate the corresponding java code
<p align="right">(<a href="#readme-top">back to top</a>)</p>


## If you want to build it yourself : 
As the project is based on eclipse technologies (OCL eclipse, xtext ...) the projects are eclipse plugins. A standalone build procedure is available, forming an uber-jar with all the necessary dependencies. 

To build the project :
* run the build.sh script that compile ```fr.inria.diverse.swhModel``` then ```fr.inria.diverse.swhModel.generator```
* The jar is also installed in your local m2 repository to run tests

Then you can run the test project :
* run ```mvn test``` in ```fr.inria.diverse.swhModel.generator.tests```

Note: the fingerprint project is build automatically by using the oclQueryCompilerLaucher.sh scripts 
<p align="right">(<a href="#readme-top">back to top</a>)</p>


## Tutorial
A jupyter notebook is available in the ```tutorial``` folder. It describe and E2E exemple of designing a dataset from a fingerprint over a reduced dataset.
A conda environment export is in environment.yml, you can create a conda environment (conda env create -f environment.yml) and open the tutorial notebook with vscode integrated jupyter notebook.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

romain.lefeuvre@inria.fr.com

Project Link: [https://github.com/RomainLefeuvre/DatasetBuilder](https://github.com/RomainLefeuvre/DatasetBuilder)

<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN.svg?style=for-the-badge
[contributors-url]: https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN.svg?style=for-the-badge
[forks-url]: https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/network/members
[stars-shield]: https://img.shields.io/github/stars/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN.svg?style=for-the-badge
[stars-url]: https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/stargazers
[issues-shield]: https://img.shields.io/github/issues/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN.svg?style=for-the-badge
[issues-url]: https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/issues
[license-shield]: https://img.shields.io/github/license/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN.svg?style=for-the-badge
[license-url]: https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
