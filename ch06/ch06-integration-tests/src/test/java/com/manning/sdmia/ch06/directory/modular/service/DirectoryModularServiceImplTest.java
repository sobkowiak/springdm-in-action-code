package com.manning.sdmia.ch06.directory.modular.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.osgi.framework.ServiceReference;
import org.springframework.jdbc.core.JdbcTemplate;

import com.manning.sdmia.ch06.AbstractTest;
import com.manning.sdmia.directory.domain.Contact;
import com.manning.sdmia.directory.service.ContactService;

/**
 * 
 * @author acogoluegnes
 *
 */
public class DirectoryModularServiceImplTest extends AbstractTest {
	
	/** Dummy property to dynamically add the import-package */
	private BasicDataSource basicDataSource;
	
	private DataSource dataSource;

	public void testIntegration() throws Exception {
		// waits a little for the datasource service (from test) to be imported by dao impl bundle
		Thread.sleep(1000);
		
		// creates table and inject data
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.batchUpdate(new String [] {
			"CREATE SEQUENCE seq_directory_contact_idcontact START WITH 1 INCREMENT BY 1",
			"create table directory_contact(idcontact integer not null, firstname varchar(255), lastname varchar(255), primary key (idcontact))",
			"insert into directory_contact (idcontact,firstname,lastname) values (NEXT VALUE FOR seq_directory_contact_idcontact,'arnaud','cogoluegnes')"			
		});
		
		ServiceReference serviceRef = bundleContext.getServiceReference(ContactService.class.getName());
		
		assertNotNull("Service Reference is null",serviceRef);
		
		ContactService service = (ContactService) bundleContext.getService(serviceRef);
		assertNotNull("Cannot find the business service",service);
		
		List<Contact> contacts = service.getContacts();

		assertEquals(1,contacts.size());		
	}	
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia.ch06, directory-domain, 1.0.0",
				"com.manning.sdmia.ch06, directory-modular-dao, 1.0.0",	
				"com.manning.sdmia.ch06, directory-modular-dao-jdbc, 1.0.0",
				"com.manning.sdmia.ch06, directory-service, 1.0.0",			
				"com.manning.sdmia.ch06, directory-modular-service-impl, 1.0.0",			
				"com.manning.sdmia.ch06, commons-pool.osgi, 1.3.0",
				"com.manning.sdmia.ch06, commons-dbcp.osgi, 1.2.2",				
				"com.h2database, h2, 1.1.115",
				"org.springframework, org.springframework.jdbc, "+getSpringVersion(),
				"org.springframework, org.springframework.transaction, "+getSpringVersion()
		};
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch06/directory/modular/service/DirectoryModularServiceImplTest-context.xml"};
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
