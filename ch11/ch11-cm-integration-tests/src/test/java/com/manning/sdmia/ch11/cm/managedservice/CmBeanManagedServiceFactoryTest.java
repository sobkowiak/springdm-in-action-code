/**
 * 
 */

package com.manning.sdmia.ch11.cm.managedservice;

import com.manning.sdmia.ch11.cm.AbstractCmTest;
import com.manning.sdmia.ch11.cm.placeholder.MockDataSource;

/**
 * @author Thierry Templier
 */
public class CmBeanManagedServiceFactoryTest extends AbstractCmTest {

	public void testConfigurationAdminAccessAfterInit() throws Exception {
		showProperties("data.source.conf");
		
		/*BeanDataSourceManagedService datasourceService
			= (BeanDataSourceManagedService) getApplicationContext().getBean("dataSourceManagedService");

		MockDataSource dataSource = datasourceService.getDataSource();
		
		assertNull(dataSource.getDriverClassName());
		assertNull(dataSource.getUrl());
		assertNull(dataSource.getUsername());
		assertNull(dataSource.getPassword());*/
		
		initializeConfigAdmin("data.source.conf", "driverClassName", "org.h2.Driver");
		initializeConfigAdmin("data.source.conf", "url", "jdbc:h2:tcp://localhost/springdm-directory");
		initializeConfigAdmin("data.source.conf", "username", "sa");
		initializeConfigAdmin("data.source.conf", "password", "");

		/*assertEquals("org.h2.Driver", dataSource.getDriverClassName());
		assertEquals("jdbc:h2:tcp://localhost/springdm-directory", dataSource.getUrl());
		assertEquals("sa", dataSource.getUsername());
		assertEquals("", dataSource.getPassword());*/
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch11/cm/managedservice/cm-bean-managedservicefactory-context.xml"};
	}

}
