/**
 * 
 */
package com.manning.sdmia.directory.test.dao;

import junit.framework.Assert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.directory.dao.ContactDao;

/**
 * @author acogoluegnes
 *
 */
public class ContactDaoServiceDataSourceIntegrationTest extends
		AbstractConfigurableBundleCreatorTests {
	
	private JdbcTemplate jdbcTemplate;
	
	private ContactDao contactDao;

	public void testGetContacts() throws Exception {
		Assert.assertEquals(1,contactDao.getContacts().size());
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.ch10, directory-domain, 1.0.0",
			"com.manning.sdmia.ch10, directory-dao, 1.0.0",
			"com.manning.sdmia.ch10, directory-dao-jdbc, 1.0.0",		
			"org.springframework, org.springframework.jdbc, "+getSpringVersion(),
			"org.springframework, org.springframework.transaction, "+getSpringVersion(),
			"com.h2database, h2, 1.1.118",
			"com.manning.sdmia.ch10, ch10-datasource-tests, 1.0.0"
		};
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] {
			"/com/manning/sdmia/directory/test/dao/ContactDaoServiceDataSourceIntegrationTest-context.xml"};
	}
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
}
