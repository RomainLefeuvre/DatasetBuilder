#!/bin/bash
# Check that the file path was provided as the first argument
if [ -z "$1" ]; then
  echo "Please provide an ocl model as the first argument."
  exit 1
fi

# Check that the file path is valid
if [ ! -f "$1" ]; then
  echo "The file path you provided is not valid."
  exit 1
fi
ocl_model="$1"

if [ -z "$2" ]; then
  echo "Please provide a query_name as the second argument."
  exit 1
fi
query_name="$2"

# Set the default destination path to the current directory
dest_path="./result"

# Check if a destination path was provided as the second argument
if [ -n "$3" ]; then
  dest_path="$3"
fi

# Check that the destination path is valid
if [ ! -d "$dest_path" ]; then
  echo "The destination path you provided is not valid."
  exit 1
fi

java -jar ./fr.inria.diverse.swhModel.generator/fr.inria.diverse.swhModel_0.1.0.jar "$ocl_model" "${dest_path}/GraphQuery.java" "${query_name}"
fingerprint_dest="./fr.inria.diverse.fingerprint/src/main/java/fr/inria/diverse/query/GraphQuery.java"
echo "Copying the produce ${dest_path}/GraphQuery.java in ${fingerprint_dest} "

cp "${dest_path}/GraphQuery.java" "$fingerprint_dest"
# Copy the file to the destination path

echo "Building fr.inria.diverse.fingerprint"
fr.inria.diverse.fingerprint/mvnw clean package -Dmaven.test.skip=true -f ./fr.inria.diverse.fingerprint/pom.xml
echo "Copying jar in ${dest_path}"
cp fr.inria.diverse.fingerprint/target/fr.inria.diverse.fingerprint-0.1.0.jar ${dest_path}/fr.inria.diverse.fingerprint-0.1.0.jar
echo "Done !"
exit 0
