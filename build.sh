#!/bin/bash
echo "----Compiling swhModel----"
cd ./fr.inria.diverse.swhModel/
ant build.update.jar
echo "----Compiling swhModelGenerator----"
cd ../fr.inria.diverse.swhModel.generator/
ant create_uber_jar
