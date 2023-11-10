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

