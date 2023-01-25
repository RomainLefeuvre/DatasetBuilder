#!/bin/bash
for dir in */jar; do
    echo "------Installing $dir dependency to local maven repo------"
    jar=$(find "./$dir" -name *.jar)
    pom=${dir}/../pom.xml
    echo "mvn install:install-file -Dfile=$jar -DpomFile=$pom"
    mvn install:install-file -Dfile=$jar -DpomFile=$pom 
done
