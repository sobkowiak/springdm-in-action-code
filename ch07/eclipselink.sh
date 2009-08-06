#!/bin/sh

./common.sh

cd container
./copyJarEclipseLink.sh
cd -

cd ch07-jpa-eclipselink-integration-tests
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn test
cd -

