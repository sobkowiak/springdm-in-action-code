- Add the following bundles of Restlet into your local maven repository using the
install-file task of Maven: 

/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install:install-file -DgroupId=org.apache.myfaces -DartifactId=myfaces-api -Dversion=1.2.2 -Dfile=myfaces-api-osgi-1.2.2.jar -Dpackaging=jar -DgeneratePom=true
/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install:install-file -DgroupId=org.apache.myfaces -DartifactId=myfaces-impl -Dversion=1.2.2 -Dfile=myfaces-impl-osgi-1.2.2.jar -Dpackaging=jar -DgeneratePom=true

/home/templth/developpement/applications/apache-maven-2.0.9/bin/mvn install:install-file -DgroupId=javax.servlet -DartifactId=com.springsource.javax.servlet.jsp.jstl -Dversion=1.2.0 -Dfile=com.springsource.javax.servlet.jsp.jstl-1.2.0.jar -Dpackaging=jar -DgeneratePom=true

- Necessary bundles to run this web bundle:

net.sourceforge.cglib, com.springsource.net.sf.cglib, 2.1.3
org.springframework.osgi, spring-osgi-web, 2.0.0.M1
org.springframework.osgi, spring-osgi-web-extender, 2.0.0.M1
org.springframework, org.springframework.context.support, 3.0.0.RC1
org.springframework, org.springframework.web, 3.0.0.RC1
org.springframework, org.springframework.web.servlet, 3.0.0.RC1
org.apache.log4j, com.springsource.org.apache.log4j, 1.2.15                               
org.aspectj, com.springsource.org.aspectj.runtime, 1.6.1           
org.aspectj, com.springsource.org.aspectj.weaver, 1.6.1                
org.springframework.osgi, catalina.start.osgi, 1.0-SNAPSHOT
javax.activation, com.springsource.javax.activation, 1.1.1
javax.annotation, com.springsource.javax.annotation, 1.0.0
javax.ejb, com.springsource.javax.ejb, 3.0.0
javax.el, com.springsource.javax.el, 1.0.0
javax.mail, com.springsource.javax.mail, 1.4.1
javax.persistence, com.springsource.javax.persistence, 1.99.0
javax.servlet, com.springsource.javax.servlet, 2.5.0
javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0
javax.servlet, com.springsource.javax.servlet.jsp.jstl, 1.2.0
javax.xml.bind, com.springsource.javax.xml.bind, 2.1.7
javax.xml.rpc, com.springsource.javax.xml.rpc, 1.1.0
javax.xml.soap, com.springsource.javax.xml.soap, 1.3.0
javax.xml.stream, com.springsource.javax.xml.stream, 1.0.1
javax.xml.ws, com.springsource.javax.xml.ws, 2.1.1
org.apache.catalina.springsource, com.springsource.org.apache.catalina.springsource, 6.0.20.S2-r5956
org.apache.commons, com.springsource.org.apache.commons.beanutils, 1.8.0
org.apache.commons, com.springsource.org.apache.commons.codec-1.4.0
org.apache.commons, com.springsource.org.apache.commons.collections, 3.2.1
org.apache.commons, com.springsource.org.apache.commons.digester, 1.8.1
org.apache.commons, com.springsource.org.apache.commons.logging, 1.1.1
org.apache.coyote.springsource, com.springsource.org.apache.coyote.springsource, 6.0.20.S2-r5956
org.apache.el.springsource, com.springsource.org.apache.el.springsource, 6.0.20.S2-r5956
org.apache.jasper, com.springsource.org.apache.jasper.org.eclipse.jdt, 6.0.16
org.apache.jasper.springsource, com.springsource.org.apache.jasper.org.eclipse.jdt.springsource, 6.0.20.S2-r5956
org.apache.jasper.springsource, com.springsource.org.apache.jasper.springsource, 6.0.20.S2-r5956
org.apache.juli.springsource, com.springsource.org.apache.juli.extras.springsource, 6.0.20.S2-r5956
org.apache.xmlcommons, com.springsource.org.apache.xmlcommons, 1.3.4
org.apache.myfaces, myfaces-api-osgi, 1.2.2
org.apache.myfaces, myfaces-impl-osgi, 1.2.2

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

http://localhost:8080/myfaces/contacts.jsf

- Caution:

The bundle javax.servlet, com.springsource.javax.servlet.jsp.jstl, 1.2.0 contains
a wrong import package for the package javax.el. A correct bundle is provided
in the bundles directory of the source code.

You need to add the provided version of this bundle in the bundles/myfaces directory
using the following mvn command:

mvn install:install-file -DgroupId=javax.servlet -DartifactId=com.springsource.javax.servlet.jsp.jstl -Dversion=1.2.0 -Dfile=com.springsource.javax.servlet.jsp.jstl-1.2.0.jar -Dpackaging=jar -DgeneratePom=true
