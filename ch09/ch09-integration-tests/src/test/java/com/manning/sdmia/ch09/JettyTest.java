/**
 * 
 */
package com.manning.sdmia.ch09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public class JettyTest extends AbstractConfigurableBundleCreatorTests {
	
	private static final String SPRING_OSGI_GROUP = "org.springframework.osgi";
	private static final String JETTY_VERSION = "6.1.19";

	public void testLaunchJetty() throws Exception {
		// waits a little for everything to be deployed correctly
		Thread.sleep(3000);
		
		String pageContent = getTextResponse("http://localhost:8080/simplewebmvcapp/hello.htm");
		
		Assert.assertTrue(pageContent.contains("Hello from chapter 09! Today we are"));
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		List<String> col = new ArrayList<String>();

		// Servlet/JSP artifacts
		col.add(SPRING_OSGI_GROUP + ", servlet-api.osgi, 2.5-SNAPSHOT");
		col.add("org.mortbay.jetty, jsp-api-2.1, 6.1.14");

		// JSP compiler
		col.add(SPRING_OSGI_GROUP + ", jasper.osgi, 6.0.16-SNAPSHOT");
		col.add(SPRING_OSGI_GROUP + ", commons-el.osgi, 1.0-SNAPSHOT");

		// standard tag library
		col.add(SPRING_OSGI_GROUP+", jstl.osgi, 1.1.2-SNAPSHOT");
		
		// web container
		col.add("org.mortbay.jetty, jetty, "+JETTY_VERSION);
		col.add("org.mortbay.jetty, jetty-util, "+JETTY_VERSION);
		col.add(SPRING_OSGI_GROUP + ", jetty.web.extender.fragment.osgi, 1.0.1");
		col.add(SPRING_OSGI_GROUP + ", jetty.start.osgi, 1.0.0");

		// Spring DM web extender
		col.add(SPRING_OSGI_GROUP + ", spring-osgi-web," + getSpringDMVersion());
		col.add(SPRING_OSGI_GROUP + ", spring-osgi-web-extender," + getSpringDMVersion());
		col.add("net.sourceforge.cglib, com.springsource.net.sf.cglib, 2.1.3");

		// database access
		col.add("com.manning.sdmia, commons-pool.osgi, 1.3.0-SNAPSHOT");
		col.add("com.manning.sdmia, commons-dbcp.osgi, 1.2.2-SNAPSHOT");
		col.add("com.h2database, h2, 1.1.115");
		col.add("org.springframework, org.springframework.jdbc, "+getSpringVersion());
		col.add("org.springframework, org.springframework.transaction, "+getSpringVersion());
		
		// Spring Web
		col.add("org.springframework, org.springframework.web, "+getSpringVersion());
		col.add("org.springframework, org.springframework.web.servlet, "+getSpringVersion());
		
		// simple web app
		col.add("com.manning.sdmia.ch09, simple-web-mvc-app, 1.0.0.SNAPSHOT");
		
		return (String[]) col.toArray(new String[col.size()]);
	}
	
	private String getTextResponse(String address) throws Exception {
		URL url = new URL(address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setUseCaches(false);
		BufferedReader in = null;
		try {
			con.connect();
			assertEquals(HttpURLConnection.HTTP_OK, con.getResponseCode());
			in = new BufferedReader(
                    new InputStreamReader(
                    con.getInputStream())
            );
			StringBuilder builder = new StringBuilder();
			String inputLine = null;
			while((inputLine = in.readLine()) != null) {
				builder.append(inputLine);
			}
			return builder.toString();
		}
		finally {
			if(in != null) {
				in.close();
			}
			con.disconnect();
		}
	}
	
}
