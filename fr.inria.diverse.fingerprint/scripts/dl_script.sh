#!/bin/bash  
set -e
mkdir -p ../dataset
while read line
do  
  aws s3 cp --no-sign-request s3://softwareheritage/graph/2021-03-23/compressed/$line ./2021-03-23/compressed
done <filename.txt
