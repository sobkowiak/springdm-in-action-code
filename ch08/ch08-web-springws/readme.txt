- Necessary bundles to run this web bundle:

org.springframework.osgi, spring-osgi-web, 1.2.0
org.springframework.osgi, spring-osgi-web-extender, 1.2.0
org.springframework, org.springframework.context.support, 2.5.6.SEC01
org.springframework, org.springframework.web, 2.5.6.SEC01
org.springframework, org.springframework.web.servlet, 2.5.6.SEC01
com.sun.xml, com.springsource.com.sun.xml.messaging.saaj, 1.3.0     
com.thoughtworks.xstream, com.springsource.com.thoughtworks.xstream, 1.3.1       
javax.activation, com.springsource.javax.activation, 1.1.1               
javax.ejb, com.springsource.javax.ejb, 3.0.0                      
javax.el, com.springsource.javax.el, 2.1.0                       
javax.jms, com.springsource.javax.jms, 1.1.0                      
javax.mail, com.springsource.javax.mail, 1.4.1                     
javax.servlet, com.springsource.javax.servlet, 2.5.0                  
javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0              
org.springframework.osgi, catalina.osgi, 5.5.23-SNAPSHOT                            
org.springframework.osgi, catalina.start.osgi, 1.0-SNAPSHOT                         
org.springframework.osgi, jasper.osgi, 5.5.23-SNAPSHOT
javax.wsdl, com.springsource.javax.wsdl, 1.6.1                     
javax.xml.bind, com.springsource.javax.xml.bind, 2.1.7                 
javax.xml.rpc, com.springsource.javax.xml.rpc, 1.1.0                  
javax.xml.soap, com.springsource.javax.xml.soap, 1.3.0                 
javax.xml.stream, com.springsource.javax.xml.stream, 1.0.1               
org.apache.commons, com.springsource.org.apache.commons.codec, 1.4.0       
org.apache.commons, com.springsource.org.apache.commons.el, 1.0.0          
org.apache.commons, com.springsource.org.apache.commons.httpclient, 3.1.0  
org.apache.ws, com.springsource.org.apache.ws.commons.schema, 1.3.2   
org.jdom, com.springsource.org.jdom, 1.1.0                       
org.xmlpull, com.springsource.org.xmlpull, 1.1.4.c                  
org.springframework.ws, org.springframework.oxm, 1.5.7.A
org.springframework.ws, org.springframework.oxm.java5, 1.5.7.A
org.springframework.ws, org.springframework.ws, 1.5.7.A
org.springframework.ws, org.springframework.ws.java5, 1.5.7.A
org.springframework.ws, org.springframework.ws.transport, 1.5.7.A
org.springframework.ws, org.springframework.xml, 1.5.7.A

- Present bundles in the Spring DM test platform: 

org.aopalliance, com.springsource.org.aopalliance, 1.0.0
org.apache.log4j, com.springsource.org.apache.log4j, 1.2.15
org.junit, com.springsource.junit, 3.8.2
org.objectweb.asm, com.springsource.org.objectweb.asm, 2.2.3
org.slf4j, com.springsource.slf4j.api, 1.5.6
org.slf4j, com.springsource.slf4j.log4j, 1.5.6
org.slf4j, com.springsource.slf4j.org.apache.commons.logging, 1.5.6
org.springframework, org.springframework.aop, 2.5.6.SEC01
org.springframework, org.springframework.beans, 2.5.6.SEC01
org.springframework, org.springframework.context, 2.5.6.SEC01
org.springframework, org.springframework.core, 2.5.6.SEC01
org.springframework, org.springframework.test, 2.5.6.SEC01
org.springframework.osgi, spring-osgi-annotation, 1.2.0
org.springframework.osgi, spring-osgi-core, 1.2.0
org.springframework.osgi, spring-osgi-extender, 1.2.0
org.springframework.osgi, spring-osgi-io, 1.2.0
org.springframework.osgi, spring-osgi-test, 1.2.0

- Root URL to access Web services of the Web application:

http://localhost:8080/springws/

- Caution:

The bundle javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0 contains
a wrong import package for the package javax.el. A correct bundle is provided
in the bundles directory of the source code.