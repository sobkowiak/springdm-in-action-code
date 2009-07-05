package com.manning.sdmia.ch06.enterprise.soa.service;

import java.util.List;

import javax.sql.DataSource;

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
public class EnterpriseSoaServiceImplTest extends AbstractConfigurableBundleCreatorTests {
	
	/** Dummy property to dynamically add the import-package */
	private BasicDataSource basicDataSource;
	
	private DataSource dataSource;

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
	}	
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia, enterprise-domain, 1.0.0-SNAPSHOT",		
				"com.manning.sdmia, enterprise-service, 1.0.0-SNAPSHOT",			
				"com.manning.sdmia, enterprise-soa-service-impl, 1.0.0-SNAPSHOT",			
				"com.manning.sdmia, commons-pool.osgi, 1.3.0-SNAPSHOT",
				"com.manning.sdmia, commons-dbcp.osgi, 1.2.2-SNAPSHOT",
				"com.h2database, h2, 1.1.115",
				"org.springframework, org.springframework.jdbc, "+getSpringVersion(),
				"org.springframework, org.springframework.transaction, "+getSpringVersion()
		};
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch06/enterprise/soa/service/EnterpriseSoaServiceImplTest-context.xml"};
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
}
