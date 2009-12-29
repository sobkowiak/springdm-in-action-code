/**
 * 
 */

package com.manning.sdmia.ch11.cm.managedservice;

import com.manning.sdmia.ch11.cm.AbstractCmTest;
import com.manning.sdmia.ch11.cm.placeholder.MockDataSource;

/**
 * @author Thierry Templier
 */
public class CmSimpleManagedServiceTest extends AbstractCmTest {

	public void testConfigurationAdminAccessAfterInit() throws Exception {
		showProperties("data.source.conf");
		
		DataSourceManagedService datasourceService
			= (DataSourceManagedService) getApplicationContext().getBean("dataSourceManagedService");

		MockDataSource dataSource = datasourceService.getDataSource();
		
		assertNull(dataSource.getDriverClassName());
		assertNull(dataSource.getUrl());
		assertNull(dataSource.getUsername());
		assertNull(dataSource.getPassword());
		
		initializeConfigAdmin("data.source.conf", "jdbc.driverClassName", "org.h2.Driver");
		initializeConfigAdmin("data.source.conf", "jdbc.url", "jdbc:h2:tcp://localhost/springdm-directory");
		initializeConfigAdmin("data.source.conf", "jdbc.username", "sa");
		initializeConfigAdmin("data.source.conf", "jdbc.password", "");

		assertEquals("org.h2.Driver", dataSource.getDriverClassName());
		assertEquals("jdbc:h2:tcp://localhost/springdm-directory", dataSource.getUrl());
		assertEquals("sa", dataSource.getUsername());
		assertEquals("", dataSource.getPassword());
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch11/cm/managedservice/cm-managedservice-context.xml"};
	}

}
