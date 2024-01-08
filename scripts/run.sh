#!/bin/bash
cd ../target/
CMD="java -jar employeeservice-*.jar"
echo  "Executing command:  $CMD"
exec $CMD
