- Add the following bundle of DWR into your local maven repository using the
install-file task of Maven: 

mvn install:install-file -DgroupId=org.directwebremoting -DartifactId=com.springsource.uk.ltd.getahead.dwr -Dversion=2.0.5 -Dfile=dwr-osgi-2.0.5.jar -Dpackaging=jar -DgeneratePom=true

- Necessary bundles to run this web bundle:

net.sourceforge.cglib, com.springsource.net.sf.cglib, 2.1.3
org.springframework, org.springframework.context.support, 3.0.0.RC1
org.springframework, org.springframework.web, 3.0.0.RC1
org.springframework, org.springframework.web.servlet, 3.0.0.RC1
org.apache.log4j, com.springsource.org.apache.log4j, 1.2.15                               
org.springframework.osgi, catalina.osgi, 5.5.23-SNAPSHOT                            
org.springframework.osgi, catalina.start.osgi, 1.0-SNAPSHOT                         
javax.el, com.springsource.javax.el, 2.1.0   
javax.servlet, com.springsource.javax.servlet, 2.5.0
javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0
javax.servlet, com.springsource.javax.servlet.jsp.jstl, 1.1.2            
org.apache.commons, com.springsource.org.apache.commons.el, 1.0.0             
org.apache.taglibs, com.springsource.org.apache.taglibs.standard, 1.1.2       
org.aspectj, com.springsource.org.aspectj.runtime, 1.6.1           
org.aspectj, com.springsource.org.aspectj.weaver, 1.6.1                
org.directwebremoting, com.springsource.uk.ltd.getahead.dwr,2.0.5
org.springframework.osgi, jasper.osgi, 5.5.23-SNAPSHOT                              
org.springframework.osgi, spring-osgi-web, 2.0.0.M1
org.springframework.osgi, spring-osgi-web-extender, 2.0.0.M1
			
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

- Caution:

The bundle javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0 contains
a wrong import package for the package javax.el. A correct bundle is provided
in the bundles directory of the source code.

You need to add the provided version of this bundle in the bundles/springws directory
using the following mvn command:

mvn install:install-file -DgroupId=javax.servlet -DartifactId=com.springsource.javax.servlet.jsp -Dversion=2.1.0 -Dfile=com.springsource.javax.servlet.jsp-2.1.0.jar -Dpackaging=jar -DgeneratePom=true
