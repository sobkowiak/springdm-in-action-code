/**
 * 
 */
package com.manning.sdmia.ch11.cm.properties;

import java.util.Properties;

import com.manning.sdmia.ch11.cm.AbstractCmTest;


/**
 * @author Thierry Templier
 */
public class CmPropertiesTest extends AbstractCmTest {
	
	public void testConfigurationAdminAccess() throws Exception {
		initializeConfigAdmin("data.source.conf", "jdbc.username", "sa");
		initializeConfigAdmin("data.source.conf", "jdbc.password", "");
		showProperties("data.source.conf");
		
		Properties datasourceConfiguration
			= (Properties) getApplicationContext().getBean("dataSourceConfiguration");
		assertEquals("org.h2.Driver", datasourceConfiguration.getProperty("jdbc.driverClassName"));
		assertEquals("jdbc:h2:tcp://localhost/springdm-directory", datasourceConfiguration.getProperty("jdbc.url"));
		assertEquals("sa", datasourceConfiguration.getProperty("jdbc.username"));
		assertEquals("", datasourceConfiguration.getProperty("jdbc.password"));
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch11/cm/properties/cm-properties-context.xml"};
	}

}
