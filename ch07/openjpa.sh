#!/bin/sh

./common.sh

cd container
./copyJarOpenJPA.sh
cd -

cd ch07-jpa-openjpa-integration-tests
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn test
cd -

