package com.manning.sdmia.web.springws;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author Thierry Templier
 */
public class SpringWsTest extends AbstractConfigurableBundleCreatorTests {
	private WebServiceTemplate webServiceTemplate;

	public void testWebapp() throws Exception {
		// waits a little for the tomcat service (from test) to be started
		Thread.sleep(2000);
		
    	String message = "<GetContactsRequest xmlns=\"http://www.manning.com/directory/schemas\"/>";
    	StreamSource source = new StreamSource(new StringReader(message));
    	StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
        		"<GetContactsResponse>" +
        		"<Contacts>" +
        		"<Id>1</Id><FirstName>Arnaud</FirstName><LastName>Cogoluegnes</LastName>" +
        		"</Contacts>" +
        		"<Contacts>" +
        		"<Id>2</Id><FirstName>Andy</FirstName><LastName>Piper</LastName>" +
        		"</Contacts>" +
        		"<Contacts>" +
        		"<Id>3</Id><FirstName>Thierry</FirstName><LastName>Templier</LastName>" +
        		"</Contacts>" +
        		"</GetContactsResponse>", writer.toString());
	}	
	
	@Override
	protected String[] getTestFrameworkBundlesNames() {
		return new String[] {
				"org.aopalliance, com.springsource.org.aopalliance, 1.0.0",
				"org.apache.log4j, com.springsource.org.apache.log4j, 1.2.15",
				"org.junit, com.springsource.junit, 3.8.2",
				"org.objectweb.asm, com.springsource.org.objectweb.asm, 2.2.3",
				"org.slf4j, com.springsource.slf4j.api, 1.5.6",
				"org.slf4j, com.springsource.slf4j.log4j, 1.5.6",
				"org.slf4j, com.springsource.slf4j.org.apache.commons.logging, 1.5.6",
				"org.springframework, org.springframework.aop, 2.5.6.SEC01",
				//"org.springframework, org.springframework.asm, 2.5.6",
				"org.springframework, org.springframework.beans, 2.5.6.SEC01",
				"org.springframework, org.springframework.context, 2.5.6.SEC01",
				"org.springframework, org.springframework.core, 2.5.6.SEC01",
				//"org.springframework, org.springframework.expression, 2.5.6",
				"org.springframework, org.springframework.test, 2.5.6.SEC01",
				"org.springframework.osgi, spring-osgi-annotation, 1.2.0",
				"org.springframework.osgi, spring-osgi-core, 1.2.0",
				"org.springframework.osgi, spring-osgi-extender, 1.2.0",
				"org.springframework.osgi, spring-osgi-io, 1.2.0",
				"org.springframework.osgi, spring-osgi-test, 1.2.0"
			};
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String[] {
			"org.springframework.osgi, spring-osgi-web, 1.2.0",
			"org.springframework.osgi, spring-osgi-web-extender, 1.2.0",
			"org.springframework, org.springframework.context.support, 2.5.6.SEC01",
			"org.springframework, org.springframework.web, 2.5.6.SEC01",
			"org.springframework, org.springframework.web.servlet, 2.5.6.SEC01",
			//"org.aspectj, com.springsource.org.aspectj.runtime, 1.6.1",           
			//"org.aspectj, com.springsource.org.aspectj.weaver, 1.6.1",                
			
			"com.sun.xml, com.springsource.com.sun.xml.messaging.saaj, 1.3.0",     
			"com.thoughtworks.xstream, com.springsource.com.thoughtworks.xstream, 1.3.1",       
			"javax.activation, com.springsource.javax.activation, 1.1.1",               
			"javax.ejb, com.springsource.javax.ejb, 3.0.0",                      
			"javax.el, com.springsource.javax.el, 2.1.0",                       
			"javax.jms, com.springsource.javax.jms, 1.1.0",                      
			"javax.mail, com.springsource.javax.mail, 1.4.1",                     
			"javax.servlet, com.springsource.javax.servlet, 2.5.0",                  
			"javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0",              
			//"javax.servlet, com.springsource.javax.servlet.jsp, 2.0.0",              
			//"javax.servlet, com.springsource.javax.servlet.jsp.jstl, 1.1.2",         
			"org.springframework.osgi, catalina.osgi, 5.5.23-SNAPSHOT",                            
			"org.springframework.osgi, catalina.start.osgi, 1.0-SNAPSHOT",                         
			"org.springframework.osgi, jasper.osgi, 5.5.23-SNAPSHOT",
			"javax.wsdl, com.springsource.javax.wsdl, 1.6.1",                     
			"javax.xml.bind, com.springsource.javax.xml.bind, 2.1.7",                 
			"javax.xml.rpc, com.springsource.javax.xml.rpc, 1.1.0",                  
			"javax.xml.soap, com.springsource.javax.xml.soap, 1.3.0",                 
			"javax.xml.stream, com.springsource.javax.xml.stream, 1.0.1",               
			"org.apache.commons, com.springsource.org.apache.commons.codec, 1.4.0",       
			"org.apache.commons, com.springsource.org.apache.commons.el, 1.0.0",          
			"org.apache.commons, com.springsource.org.apache.commons.httpclient, 3.1.0",  
			//"org.apache.commons, com.springsource.org.apache.taglibs.standard, 1.1.2",    
			"org.apache.ws, com.springsource.org.apache.ws.commons.schema, 1.3.2",   
			"org.jdom, com.springsource.org.jdom, 1.1.0",                       
			"org.xmlpull, com.springsource.org.xmlpull, 1.1.4.c", //--                    
			"org.springframework.ws, org.springframework.oxm, 1.5.7.A",
			"org.springframework.ws, org.springframework.oxm.java5, 1.5.7.A",
			"org.springframework.ws, org.springframework.ws, 1.5.7.A",
			"org.springframework.ws, org.springframework.ws.java5, 1.5.7.A",
			"org.springframework.ws, org.springframework.ws.transport, 1.5.7.A",
			"org.springframework.ws, org.springframework.xml, 1.5.7.A",

			"com.manning.sdmia.ch08, ch08-directory, 1.0-SNAPSHOT",
			"com.manning.sdmia.ch08, ch08-springws, 1.0-SNAPSHOT"
		};
	}
	
	/*
-- castor-1.2-xml-osgi.jar                                   
## catalina.osgi-5.5.23-SNAPSHOT.jar                         
## catalina.start.osgi-1.0-SNAPSHOT.jar                      
## com.springsource.com.sun.xml.messaging.saaj-1.3.0.jar     
## com.springsource.com.thoughtworks.xstream-1.3.1.jar       
## com.springsource.javax.activation-1.1.1.jar               
## com.springsource.javax.ejb-3.0.0.jar                      
## com.springsource.javax.el-2.1.0.jar                       
## com.springsource.javax.jms-1.1.0.jar                      
## com.springsource.javax.mail-1.4.1.jar                     
## com.springsource.javax.servlet-2.5.0.jar                  
## com.springsource.javax.servlet.jsp-2.1.0.jar              
## com.springsource.javax.servlet.jsp.jstl-1.1.2.jar         
## com.springsource.javax.wsdl-1.6.1.jar                     
## com.springsource.javax.xml.bind-2.1.7.jar                 
## com.springsource.javax.xml.rpc-1.1.0.jar                  
## com.springsource.javax.xml.soap-1.3.0.jar                 
## com.springsource.javax.xml.stream-1.0.1.jar               
?? com.springsource.net.sf.cglib-2.1.3.jar                   
## com.springsource.org.aopalliance-1.0.0.jar                
## com.springsource.org.apache.commons.codec-1.4.0.jar       
## com.springsource.org.apache.commons.el-1.0.0.jar          
## com.springsource.org.apache.commons.httpclient-3.1.0.jar  
## com.springsource.org.apache.taglibs.standard-1.1.2.jar    
## com.springsource.org.apache.ws.commons.schema-1.3.2.jar   
?? com.springsource.org.aspectj.runtime-1.6.1.jar            
?? com.springsource.org.aspectj.weaver-1.6.1.jar             
## com.springsource.org.jdom-1.1.0.jar                       
## com.springsource.org.xmlpull-1.1.4.jar                    
## com.springsource.slf4j.api-1.5.6.jar                      
## com.springsource.slf4j.log4j-1.5.6.jar
## com.springsource.slf4j.org.apache.commons.logging-1.5.6.jar
jasper.osgi-5.5.23-SNAPSHOT.jar
log4j.osgi-1.2.15-SNAPSHOT.jar
## org.springframework.aop-2.5.6.SEC01.jar
org.springframework.aspects-2.5.6.SEC01.jar
## org.springframework.beans-2.5.6.SEC01.jar
## org.springframework.context-2.5.6.SEC01.jar
## org.springframework.context.support-2.5.6.SEC01.jar
## org.springframework.core-2.5.6.SEC01.jar
?? org.springframework.jdbc-2.5.6.SEC01.jar
?? org.springframework.jms-2.5.6.SEC01.jar
?? org.springframework.orm-2.5.6.SEC01.jar
## org.springframework.oxm-1.5.7.A.jar
## org.springframework.oxm.java5-1.5.7.A.jar
?? org.springframework.transaction-2.5.6.SEC01.jar
## org.springframework.web-2.5.6.SEC01.jar
## org.springframework.web.servlet-2.5.6.SEC01.jar
## org.springframework.ws-1.5.7.A.jar
## org.springframework.ws.java5-1.5.7.A.jar
## org.springframework.ws.transport-1.5.7.A.jar
## org.springframework.xml-1.5.7.A.jar
?? spring-aspects.jar
## spring-osgi-annotation-1.2.0.jar
## spring-osgi-core-1.2.0.jar
## spring-osgi-extender-1.2.0.jar
## spring-osgi-io-1.2.0.jar
## spring-osgi-web-1.2.0.jar
## spring-osgi-web-extender-1.2.0.jar
	 */

	@Override
	protected String getManifestLocation() {
		return "classpath:/com/manning/sdmia/web/springws/springws.mf";
	}

	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/web/springws/webserviceclient-context.xml"};
	}

	public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

}
