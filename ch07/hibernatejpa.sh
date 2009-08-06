#!/bin/sh

./common.sh

cd container
./copyJarHibernateJpa.sh
cd -

cd ch07-jpa-hibernatejpa-integration-tests 
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn test
cd -

