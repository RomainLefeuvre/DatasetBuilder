#!/bin/bash
echo "----Compiling swhModel----"
cd ./fr.inria.diverse.swhModel/
ant build.update.jar
echo "----Compiling swhModelGenerator----"
cd ../fr.inria.diverse.swhModel.generator/
ant create_uber_jar
echo "Installing the resulting uber jar to local .m2 (To run tests)"
mvn install:install-file \
   -Dfile=fr.inria.diverse.swhModel_0.1.0.jar \
   -DgroupId=fr.inria.diverse.swhModel \
   -DartifactId=fr.inria.diverse.swhModel.generator \
   -Dversion=0.1.0 \
   -Dpackaging=jar \
