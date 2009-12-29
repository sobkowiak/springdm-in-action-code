/**
 * 
 */

package com.manning.sdmia.ch11.cm.placeholder;

import com.manning.sdmia.ch11.cm.AbstractCmTest;

/**
 * @author Thierry Templier
 */
public class CmPlaceholderTest extends AbstractCmTest {

	public void testConfigurationAdminAccessAfterInit() throws Exception {
		showProperties("data.source.conf");
		
		MockDataSource datasource = (MockDataSource) getApplicationContext().getBean("dataSource");

		assertEquals("org.h2.Driver", datasource.getDriverClassName());
		assertEquals("jdbc:h2:tcp://localhost/springdm-directory", datasource.getUrl());
		assertEquals("sa", datasource.getUsername());
		assertEquals("", datasource.getPassword());
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch11/cm/placeholder/cm-placeholder-context.xml"};
	}

}
