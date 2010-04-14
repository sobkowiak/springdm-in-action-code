/**
 * 
 */
package com.manning.sdmia.ch09;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.Bundle;
import org.springframework.osgi.test.platform.OsgiPlatform;

/**
 * @author acogoluegnes
 * 
 */
public class ConfigureWebExtenderTest extends
		AbstractOsgiTest {
	
	private static final Log LOG = LogFactory.getLog(ConfigureWebExtenderTest.class);

	public void testConfigureExtender() throws Exception {
		// waits a little for everything to be deployed correctly
		Thread.sleep(5 *1000);
		
		for(Bundle bundle : bundleContext.getBundles()) {
//			LOG.error(bundle.getSymbolicName()+" "+bundle.getBundleContext().);
		}

		// the context path is modified by the Web extender's configuration fragment
		testConnection("http://localhost:8080/manningcontextpathstrategy/hello.htm");	
		
//		findBundle("org.springframework.osgi.web.extender").stop();
//		Thread.sleep(5 * 1000);
//		findBundle("org.springframework.osgi.web.extender").start();
//		Thread.sleep(5 * 1000);

	}

	

	@Override
	protected String[] getTestBundlesNames() {
		List<String> col = new ArrayList<String>();
		
		// Servlet/JSP artifacts
		col.addAll(getJavaEe5WebArtifacts());

		// JSP compiler
		col.add(SPRING_OSGI_GROUP + ", jasper.osgi, 6.0.16-SNAPSHOT");
		col.add(SPRING_OSGI_GROUP + ", commons-el.osgi, 1.0-SNAPSHOT");

		// standard tag library
		col.add(SPRING_OSGI_GROUP+", jstl.osgi, 1.1.2-SNAPSHOT");
		
		// the Web extender configuration fragment
		col.add("com.manning.sdmia.ch09, web-extender-configuration, 1.0.0");
		
		// web container
		col.addAll(getJettyArtifacts());
		
		// Spring DM web extender
		col.addAll(getSpringDmWebArtifacts());		
		col.add("net.sourceforge.cglib, com.springsource.net.sf.cglib, 2.1.3");
		
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
