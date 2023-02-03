#!/bin/bash
#git clone https://gitlab.softwareheritage.org/swh/devel/swh-graph.git
git clone https://gitlab.softwareheritage.org/RomainLefeuvre/swh-graph.git
mvn install:install-file -Dfile=../../thirdPartyLibrary/dsiutils/dsiutils-2.7.3-SNAPSHOT.jar -DpomFile=../../thirdPartyLibrary/dsiutils/pom.xml
cd swh-graph/java/
git checkout v2.2.0-threadSafe

#git checkout v2.2.0 -b v2.2.0  
#Fixing issue with git-commit-id-plugin that do not replace the version with install job
#So first get the last git tag of this branch
#lastTag=$(git describe --abbrev=0)
#Then filter the v
#version=${lastTag#?};
#Update the pom.xml
#mvn versions:set -DnewVersion=$version
#Install it in your repository
mvn clean install -Dmaven.javadoc.skip=true
cd ../../
#Remove the temp folder
rm -r -f ./swh-graph/
