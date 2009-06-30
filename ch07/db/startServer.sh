#!/bin/sh

export HSQLDB_LIB=com.springsource.org.hsqldb-1.8.0.9.jar

java -classpath $HSQLDB_LIB org.hsqldb.Server -port 9001 -database.0 library
