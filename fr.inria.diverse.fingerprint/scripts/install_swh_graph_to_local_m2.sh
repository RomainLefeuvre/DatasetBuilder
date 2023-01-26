#!/bin/bash
mvn install:install-file -Dfile=dsiutils/dsiutils-2.7.3-SNAPSHOT.jar -DpomFile=dsiutils/pom.xml
git clone https://github.com/RomainLefeuvre/swh-graph
cd swh-graph/java/
mvn -Dmaven.javadoc.skip=true clean install
cd ../../
rm -r -f ./swh-graph/
