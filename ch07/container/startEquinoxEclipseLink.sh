#!/bin/sh

java -jar org.eclipse.osgi-3.5.0.v20081201-1815.jar -Dosgi.framework.extensions=org.eclipse.equinox.weaving.hook -Dorg.aspectj.osgi.verbose=true -configuration configuration/configuration-eclipselink
#java -jar org.eclipse.osgi-3.5.0.v20081201-1815.jar -Dorg.aspectj.osgi.verbose=true -configuration configuration/configuration-eclipselink
