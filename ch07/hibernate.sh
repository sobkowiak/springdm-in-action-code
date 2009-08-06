#!/bin/sh

./common.sh

cd container
./copyJarHibernate.sh
cd -

cd ch07-hibernate-integration-tests 
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn test
cd -

