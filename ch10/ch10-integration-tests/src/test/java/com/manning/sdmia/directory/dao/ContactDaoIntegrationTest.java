/**
 * 
 */
package com.manning.sdmia.directory.dao;

import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public class ContactDaoIntegrationTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testGetContacts() {
		
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.ch10, directory-domain, 1.0.0",
			"com.manning.sdmia.ch10, directory-dao, 1.0.0",
//			"com.manning.sdmia.ch10, directory-dao-jdbc, 1.0.0",				
		};
	}
	
//	@Override
//	protected String[] getConfigLocations() {
//		return new String[] {"/com/manning/sdmia/directory/dao/ContactDaoIntegrationTest-context.xml"};
//	}
	
}
