#!/bin/bash  
set -e
mkdir -p ./dataset
while read line
do  
  aws s3 cp --no-sign-request s3://softwareheritage/graph/2022-04-25/compressed/$line ./dataset/2022-04-25/compressed/$line
done <filename.txt
aws s3 cp --recursive --no-sign-request s3://softwareheritage/graph/2022-04-25/orc/origin_visit_status ./dataset/orc/origin_visit_status 