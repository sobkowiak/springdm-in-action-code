/**
 * 
 */

package com.manning.sdmia.ch11.cm.managedservice;

import com.manning.sdmia.ch11.cm.AbstractCmTest;
import com.manning.sdmia.ch11.cm.placeholder.MockDataSource;

/**
 * @author Thierry Templier
 */
public class CmContainerManagedServiceTest extends AbstractCmTest {

	public void testConfigurationAdminAccessAfterInit() throws Exception {
		try {
		showProperties("data.source.conf");
		
		ContainerDataSourceManagedService datasourceService
			= (ContainerDataSourceManagedService) getApplicationContext().getBean("dataSourceManagedService");

		assertNull(datasourceService.getDriverClassName());
		assertNull(datasourceService.getUrl());
		assertNull(datasourceService.getUsername());
		assertNull(datasourceService.getPassword());
		
		initializeConfigAdmin("data.source.conf", "driverClassName", "org.h2.Driver");
		initializeConfigAdmin("data.source.conf", "url", "jdbc:h2:tcp://localhost/springdm-directory");
		initializeConfigAdmin("data.source.conf", "username", "sa");
		initializeConfigAdmin("data.source.conf", "password", "");

		assertEquals("org.h2.Driver", datasourceService.getDriverClassName());
		assertEquals("jdbc:h2:tcp://localhost/springdm-directory", datasourceService.getUrl());
		assertEquals("sa", datasourceService.getUsername());
		assertEquals("", datasourceService.getPassword());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch11/cm/managedservice/cm-container-managedservice-context.xml"};
	}

}
