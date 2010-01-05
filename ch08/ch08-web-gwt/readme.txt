- Add the following bundles of Restlet into your local maven repository using the
install-file task of Maven: 

mvn install:install-file -DgroupId=com.noelios.restlet -DartifactId=org.restlet.ext.servlet -Dversion=2.0.0-SNAPSHOT -Dfile=org.restlet.ext.servlet-2.0.0.jar -Dpackaging=jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.noelios.restlet -DartifactId=org.restlet.ext.spring -Dversion=2.0.0-SNAPSHOT -Dfile=org.restlet.ext.spring-2.0.0.jar -Dpackaging=jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.noelios.restlet -DartifactId=org.restlet -Dversion=2.0.0-SNAPSHOT -Dfile=org.restlet-2.0.0.jar -Dpackaging=jar -DgeneratePom=true

- Necessary bundles to run this web bundle:



- Present bundles in the Spring DM test platform: 

org.aopalliance,com.springsource.org.aopalliance,1.0.0
org.apache.log4j,com.springsource.org.apache.log4j,1.2.15
org.junit,com.springsource.junit,3.8.2
org.objectweb.asm,com.springsource.org.objectweb.asm,2.2.3
org.slf4j,com.springsource.slf4j.api,1.5.6
org.slf4j,com.springsource.slf4j.log4j,1.5.6
org.slf4j,com.springsource.slf4j.org.apache.commons.logging,1.5.6
org.springframework,org.springframework.aop,3.0.0.RC1
org.springframework,org.springframework.asm,3.0.0.RC1
org.springframework,org.springframework.beans,3.0.0.RC1
org.springframework,org.springframework.context,3.0.0.RC1
org.springframework,org.springframework.core,3.0.0.RC1
org.springframework,org.springframework.expression,3.0.0.RC1
org.springframework,org.springframework.test,3.0.0.RC1
org.springframework.osgi,spring-osgi-annotation,2.0.0.M1
org.springframework.osgi,spring-osgi-core,2.0.0.M1
org.springframework.osgi,spring-osgi-extender,2.0.0.M1
org.springframework.osgi,spring-osgi-io,2.0.0.M1
org.springframework.osgi,spring-osgi-test,2.0.0.M1

- URL to access the Web application:

http://localhost:8080/gwt/com.manning.sdmia.gwt.DirectoryApplication/directory.html