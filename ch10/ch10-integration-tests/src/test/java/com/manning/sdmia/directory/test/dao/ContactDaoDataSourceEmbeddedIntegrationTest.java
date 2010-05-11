/**
 * 
 */
package com.manning.sdmia.directory.test.dao;

import junit.framework.Assert;

import org.h2.Driver;
import org.osgi.framework.ServiceReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.directory.dao.ContactDao;

/**
 * @author acogoluegnes
 *
 */
public class ContactDaoDataSourceEmbeddedIntegrationTest extends
		AbstractConfigurableBundleCreatorTests {
	
	private SingleConnectionDataSource dataSource;
	private Driver driver;
	private JdbcTemplate jdbcTemplate;

	public void testGetContacts() throws Exception {
		Thread.sleep(1000);
		ServiceReference ref = bundleContext.getServiceReference(ContactDao.class.getName());
		ContactDao contactDao = (ContactDao) bundleContext.getService(ref);
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
			"com.h2database, h2, 1.1.118"
		};
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] {
			"/com/manning/sdmia/directory/test/dao/ContactDaoDataSourceEmbeddedIntegrationTest-context.xml"};
	}
	
	@Override
	protected boolean shouldWaitForSpringBundlesContextCreation() {
		return false;
	}
	
	@Override
	protected Resource getTestingFrameworkBundlesConfiguration() {
		return new InputStreamResource(
				getClass().getResourceAsStream("/com/manning/sdmia/directory/test/boot-bundles.properties"));
	}	
	
}
