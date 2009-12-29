/**
 * 
 */
package com.manning.sdmia.ch11.cm.properties;

import java.util.Properties;

import com.manning.sdmia.ch11.cm.AbstractCmTest;


/**
 * @author Thierry Templier
 */
public class CmPropertiesNoUpdateTest extends AbstractCmTest {
	
	public void testConfigurationAdminAccessAfterInit() throws Exception {
		Properties datasourceConfiguration
		= (Properties) getApplicationContext().getBean("dataSourceConfiguration");

		initializeConfigAdmin("data.source.conf", "jdbc.username", "sa");
		initializeConfigAdmin("data.source.conf", "jdbc.password", "");
		showProperties("data.source.conf");
		
		assertEquals("org.h2.Driver", datasourceConfiguration.getProperty("jdbc.driverClassName"));
		assertEquals("jdbc:h2:tcp://localhost/springdm-directory", datasourceConfiguration.getProperty("jdbc.url"));
		assertNull(datasourceConfiguration.getProperty("jdbc.username"));
		assertNull(datasourceConfiguration.getProperty("jdbc.password"));
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch11/cm/properties/cm-properties-context.xml"};
	}

}
