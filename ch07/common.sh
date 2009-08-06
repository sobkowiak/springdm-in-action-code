#!/bin/sh

cd ch07-dataaccess-simple
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install
cd -

cd com.springsource.com.mchange.v2.c3p0.config
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install
cd -

cd ch07-jpa-eclipselink-simple
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install
cd -

cd ch07-jpa-openjpa-simple
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install
cd -

cd ch07-jpa-hibernatejpa-simple
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install
cd -

cd org.springframework.osgi.log4j.config
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install
cd -

