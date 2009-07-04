package com.manning.sdmia.enterprise.web;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseWebTest extends AbstractConfigurableBundleCreatorTests {
	
	private static final String SPRING_OSGI_GROUP = "org.springframework.osgi";

	public void testIntegration() throws Exception {		
		boolean bundleIsThere = false;
		for(Bundle currentBundle : bundleContext.getBundles()) {
//			String version = currentBundle.getHeaders("Bundle-Version").get("Bundle-Version").toString();
				System.out.println(currentBundle.getSymbolicName()+" "+currentBundle.getState());
		}
		Thread.sleep(1000000);
		
	}
	

	
	
	
	@Override
	protected String[] getTestBundlesNames() {
		List<String> col = new ArrayList<String>();

		// Servlet/JSP artifacts
		col.add(SPRING_OSGI_GROUP + ", servlet-api.osgi, 2.4-SNAPSHOT");
		col.add(SPRING_OSGI_GROUP + ", jsp-api.osgi, 2.0-SNAPSHOT");

		// JSP compiler
		col.add(SPRING_OSGI_GROUP + ", jasper.osgi, 5.5.23-SNAPSHOT");
		col.add(SPRING_OSGI_GROUP + ", commons-el.osgi, 1.0-SNAPSHOT");

		// standard tag library
		col.add("org.springframework.osgi, jstl.osgi, 1.1.2-SNAPSHOT");

		col.add(SPRING_OSGI_GROUP + ", catalina.osgi, 5.5.23-SNAPSHOT");
		col.add(SPRING_OSGI_GROUP + ", catalina.start.osgi, 1.0.0");

		// Spring DM web extender
		col.add(SPRING_OSGI_GROUP + ", spring-osgi-web," + getSpringDMVersion());
		col.add(SPRING_OSGI_GROUP + ", spring-osgi-web-extender," + getSpringDMVersion());
		col.add("net.sourceforge.cglib, com.springsource.net.sf.cglib, 2.1.3");

		// database access
		col.add("com.mchange.c3p0, com.springsource.com.mchange.v2.c3p0, 0.9.1.2");
		col.add("org.hsqldb, com.springsource.org.hsqldb, 1.8.0.9");
		col.add("org.springframework, spring-jdbc, 2.5.6");
		col.add("org.springframework, spring-tx, 2.5.6");
		
		// Spring Web
		col.add("org.springframework,spring-web,2.5.6");
		col.add("org.springframework,spring-webmvc,2.5.6");

		col.add("com.manning.sdmia.enterprise, enterprise-domain, 1.0-SNAPSHOT");
		col.add("com.manning.sdmia.enterprise, enterprise-c3p0-config, 1.0-SNAPSHOT");
		col.add("com.manning.sdmia.enterprise, enterprise-datasource, 1.0-SNAPSHOT");
		col.add("com.manning.sdmia.enterprise, enterprise-dao, 1.0-SNAPSHOT");
		col.add("com.manning.sdmia.enterprise, enterprise-dao-jdbc, 1.0-SNAPSHOT");
		col.add("com.manning.sdmia.enterprise, enterprise-service, 1.0-SNAPSHOT");
		col.add("com.manning.sdmia.enterprise, enterprise-service-impl, 1.0-SNAPSHOT");	

		// the war
		col.add("com.manning.sdmia.enterprise, enterprise-web, 1.0-SNAPSHOT");
		
		return (String[]) col.toArray(new String[col.size()]);
	}
	
	
	
}
