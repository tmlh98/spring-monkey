#!/bin/sh
echo 'git pull....'
git pull 


echo 'maven clean and package'
mvn clean compile package -Dmaven.test.skip=true
