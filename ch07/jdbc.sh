#!/bin/sh

./common.sh

cd container
./copyJarJdbc.sh
cd -

cd ch07-jdbc-integration-tests
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn test
cd -

