/**
 * 
 */
package com.manning.sdmia.ch09;

import java.util.ArrayList;
import java.util.List;

import org.springframework.osgi.test.platform.OsgiPlatform;

import junit.framework.Assert;

/**
 * Tomcat 6.0 BRITS (
 * Does not support JSP (see http://jira.springframework.org/browse/OSGI-689).
 * @author acogoluegnes
 *
 */
public class Tomcat6BritsTest extends AbstractOsgiTest {

	public void testLaunchJettyWithConfigurationFragment() throws Exception {
		// waits a little for everything to be deployed correctly
		Thread.sleep(5 *1000);
		
		String pageContent = getTextResponse("http://localhost:8090/simplewebmvcapp/hello.htm");
		
		Assert.assertTrue(pageContent.contains("Hello from chapter 09! Today we are"));
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		
		List<String> col = new ArrayList<String>();		
		// Servlet API
		col.add("javax.servlet, com.springsource.javax.servlet, 2.5.0");
		// standard tag library
		col.add("org.apache.taglibs, com.springsource.org.apache.taglibs.standard, 1.1.2");
		col.add("javax.servlet, com.springsource.javax.servlet.jsp.jstl, 1.1.2");
		
		// JSP API
		col.add("javax.servlet, com.springsource.javax.servlet.jsp, 2.1.0");	
		
		col.add("javax.el, com.springsource.javax.el, 1.0.0");
		col.add("org.apache.el, com.springsource.org.apache.el, 6.0.24");
		
		// web container
		col.add("javax.activation, com.springsource.javax.activation, 1.1.1");
		col.add("javax.xml.soap, com.springsource.javax.xml.soap, 1.3.0");
		col.add("javax.xml.rpc, com.springsource.javax.xml.rpc, 1.1.0");		
		col.add("javax.ejb, com.springsource.javax.ejb, 3.0.0");
		col.add("javax.persistence, com.springsource.javax.persistence, 1.0.0");
		col.add("javax.mail, com.springsource.javax.mail, 1.4.1");
		col.add("javax.xml.stream, com.springsource.javax.xml.stream, 1.0.1");
		col.add("javax.xml.bind, com.springsource.javax.xml.bind, 2.0.0");	
		col.add("javax.xml.ws, com.springsource.javax.xml.ws, 2.1.1");
		
		col.add("org.apache.coyote, com.springsource.org.apache.coyote, 6.0.24");
		col.add("org.apache.juli, com.springsource.org.apache.juli.extras, 6.0.24");		
		
		col.add("org.apache.catalina, com.springsource.org.apache.catalina, 6.0.24");
		col.add("org.apache.jasper, com.springsource.org.apache.jasper, 6.0.24");		
		col.add("org.apache.jasper, com.springsource.org.apache.jasper.org.eclipse.jdt, 6.0.24");			
		
		col.add("javax.annotation, com.springsource.javax.annotation, 1.0.0");
		
		col.add("org.springframework.osgi, catalina.start.osgi, 1.0.0");
		
		// to add default web.xml
		col.add("com.manning.sdmia.ch09, catalina-config, 1.0.0");

		// Spring DM web extender
		col.addAll(getSpringDmWebArtifacts());
		
		// web container configuration fragment
		col.add("com.manning.sdmia.ch09, tomcat-configuration-fragment, 1.0.0");
		
		// Spring Web
		col.add("org.springframework, org.springframework.web, "+getSpringVersion());
		col.add("org.springframework, org.springframework.web.servlet, "+getSpringVersion());
		col.add("org.springframework, org.springframework.context.support, "+getSpringVersion());
		
		// simple web app
		col.add("com.manning.sdmia.ch09, simple-web-mvc-app, 1.0.0");
		
		return (String[]) col.toArray(new String[col.size()]);
	}
	
	@Override
	protected OsgiPlatform createPlatform() {
		// needed starting from Spring DM 2.0.0: Spring 3.0 annotation handlers needs some XSLT
		// and the default transformer factory implementation is resolved from the META-INF/services/jstl.osgi
		// the following forces the default implementation; which is in the JDK
		// (only needed here for the Spring MVC controller to start)
		OsgiPlatform osgiPlatform = super.createPlatform();
		osgiPlatform.getConfigurationProperties().setProperty("javax.xml.transform.TransformerFactory", "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
		return osgiPlatform;
	}
	
}
