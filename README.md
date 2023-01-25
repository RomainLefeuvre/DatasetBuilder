<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
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

<h3 align="center">OCL query compiler to swh-graph java api</h3>

  <p align="center">
    project_description
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
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

<!--([![Product Name Screen Shot][product-screenshot]](https://example.com)-->



<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- GETTING STARTED -->
## Getting Started
### Prerequisites
* Java 11

#### Build Prerequisites
* Ant >= 1.10.12
* Linux
#### Tooling Prerequisites (Optional : Editor support for query)
* [GemocStudio V3.5.0](https://gemoc.org/download.html)

## Usage
### Standelone Usage
The generator can be used through the jar package version : ```fr.inria.diverse.swhModel.generator/fr.inria.diverse.swhModel_0.1.0.jar ``` : 
* run ```java -jar fr.inria.diverse.swhModel.generator/fr.inria.diverse.swhModel_0.1.0.jar <oclModelPath> <exportPath> <QueryName>``` where 
  * ```<oclModelPath>``` the path of the ocl model (either .ocl or the abstract syntax saved in .oclas)
  * ```<exportPath>``` the path were the resulting java code will be saved
  * ```<QueryId>``` the query Id, used for saving the query results during execution

Exemple : **```java -jar fr.inria.diverse.swhModel.generator/fr.inria.diverse.swhModel_0.1.0.jar fr.inria.diverse.swhModel.generator/tests/resources/swhModelQuery_01/swhModelQuery.ocl ./query.java testQuery```**

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


## Building the standalone version 
As the project is based on eclipse technologies (OCL eclipse, xtext ...) the projects eclipse plugins. A standalone build procedure is available, forming an uber-jar with all the necessary dependencies. 

To build the project :
* run the build.sh script that compile ```fr.inria.diverse.swhModel``` then ```fr.inria.diverse.swhModel.generator```
* The jar is also installed in your local m2 repository to run tests

Then you can run the test project :
* run ```mvn test``` in ```fr.inria.diverse.swhModel.generator.tests```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Feature 1
    - [ ] Nested Feature

See the [open issues](https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN/issues) for a full list of proposed features (and known issues).

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

Project Link: [https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN](https://github.com/RomainLefeuvre/OCL_QUERY_SWH-GRAPH_GEN)

<p align="right">(<a href="#readme-top">back to top</a>)</p>




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
