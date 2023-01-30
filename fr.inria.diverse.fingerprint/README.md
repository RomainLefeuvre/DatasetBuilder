<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br/>
<div align="center">
  <h3 align="center">fr.inria.diverse.fingerprint</h3>
</div>

### Prerequisites

- JAVA >= 11
- Maven >= 3.6.3

### Installation

ToDo : provide a docker container

- Create a config file based on the template
- go to scripts folder  
  `cd scripts`
- Download the last full graph dataset by running  
  `sh dl_scripts.sh`
- Install locally swh-graph to your m2 repository
  `sh install_swh_graph_to_local_m2.sh`
- Package  
  `cd ..`  
  `mvn clean package`

<!-- USAGE EXAMPLES -->

## Usage

`java -ea -server -XX:PretenureSizeThreshold=512M -XX:MaxNewSize=4G -XX:+UseLargePages -XX:+UseTransparentHugePages -XX:+UseNUMA -XX:+UseTLAB -XX:+ResizeTLAB -Djava.io.tmpdir=../java-tmp-dir -Xmx180G -jar ./target/shTest-1.0-SNAPSHOT.jar`

