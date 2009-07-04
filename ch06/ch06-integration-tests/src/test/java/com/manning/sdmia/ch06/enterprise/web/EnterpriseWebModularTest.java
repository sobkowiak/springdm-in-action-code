package com.manning.sdmia.ch06.enterprise.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.apache.commons.dbcp.BasicDataSource;
import org.osgi.framework.ServiceReference;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.enterprise.dao.UserDao;
import com.manning.sdmia.enterprise.domain.User;
import com.manning.sdmia.enterprise.service.UserService;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseWebModularTest extends AbstractConfigurableBundleCreatorTests {
	
	/** Dummy property to dynamically add the import-package */
	private BasicDataSource basicDataSource;
	
	private DataSource dataSource;
	
	private static final String SPRING_OSGI_GROUP = "org.springframework.osgi";

	public void testIntegration() throws Exception {
		// waits a little for the datasource service (from test) to be imported by dao impl bundle
		Thread.sleep(1000);
		
		// creates table and inject data
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(new String [] {
			"CREATE SEQUENCE seq_enterprise_user_iduser START WITH 1 INCREMENT BY 1",
			"create table enterprise_user(iduser integer not null, firstname varchar(255), lastname varchar(255), primary key (iduser))",
			"insert into enterprise_user (iduser,firstname,lastname) values (NEXT VALUE FOR seq_enterprise_user_iduser,'arnaud','cogoluegnes')"			
		});
		
		ServiceReference serviceRef = bundleContext.getServiceReference(UserService.class.getName());
		
		assertNotNull("Service Reference is null",serviceRef);
		
		UserService service = (UserService) bundleContext.getService(serviceRef);
		assertNotNull("Cannot find the business service",service);
		
		List<User> users = service.getUsers();

		assertEquals(1,users.size());		
		
		Assert.assertTrue(getTextResponse("http://localhost:8080/enterprise/users.htm").contains("arnaud cogoluegnes"));
		
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
		col.add(SPRING_OSGI_GROUP+", jstl.osgi, 1.1.2-SNAPSHOT");

		// web container
		col.add(SPRING_OSGI_GROUP + ", catalina.osgi, 5.5.23-SNAPSHOT");
		col.add(SPRING_OSGI_GROUP + ", catalina.start.osgi, 1.0.0");

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
		
		// the application
		col.add("com.manning.sdmia, enterprise-domain, 1.0.0-SNAPSHOT");
		col.add("com.manning.sdmia, enterprise-modular-dao, 1.0.0-SNAPSHOT");
		col.add("com.manning.sdmia, enterprise-modular-dao-jdbc, 1.0.0-SNAPSHOT");
		col.add("com.manning.sdmia, enterprise-service, 1.0.0-SNAPSHOT");
		col.add("com.manning.sdmia, enterprise-modular-service-impl, 1.0.0-SNAPSHOT");
		col.add("com.manning.sdmia, enterprise-web, 1.0.0-SNAPSHOT");
		
		return (String[]) col.toArray(new String[col.size()]);
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch06/enterprise/web/EnterpriseWebModularTest-context.xml"};
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	protected boolean shouldWaitForSpringBundlesContextCreation() {	
		// differs spring context creation for the test context to be included, so that
		// that DAO impl bundle does not wait for datasource service
		return false;
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
