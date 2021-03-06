/**
 * 
 */
package com.manning.sdmia.ch09;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.osgi.test.platform.OsgiPlatform;

import junit.framework.Assert;

/**
 * Tomcat 6.0 with Spring DM's Tomcat and Jasper bundle.
 * Does not support JSP (see http://jira.springframework.org/browse/OSGI-689).
 * @author acogoluegnes
 *
 */
public class Tomcat6SpringDMTest extends AbstractOsgiTest {

	public void testTomcat6SpringDMTest() throws Exception {
		// waits a little for everything to be deployed correctly
		Thread.sleep(5 *1000);
		
		String pageContent = getTextResponse("http://localhost:8080/simplewebmvcapp/index.html");
		Assert.assertTrue(pageContent.contains("<p>Hello from chapter 09!</p>"));
		
		// JSP not supported
		Assert.assertEquals(HttpURLConnection.HTTP_INTERNAL_ERROR,getResponseCode("http://localhost:8080/simplewebmvcapp/hello.htm"));
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		List<String> col = new ArrayList<String>();
		// Servlet/JSP artifacts
		col.addAll(getJavaEe5WebArtifacts());

		// JSP compiler
		col.add(SPRING_OSGI_GROUP + ", jasper.osgi, 6.0.16-SNAPSHOT");
//		col.add(SPRING_OSGI_GROUP + ", commons-el.osgi, 1.0-SNAPSHOT");

		// standard tag library
//		col.add(SPRING_OSGI_GROUP+", jstl.osgi, 1.1.2-SNAPSHOT");
		
		// web container
		col.addAll(getTomcat6Artifacts());		

		// Spring DM web extender
		col.addAll(getSpringDmWebArtifacts());
		
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
