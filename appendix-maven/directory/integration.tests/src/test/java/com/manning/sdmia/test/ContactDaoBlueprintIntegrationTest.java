/**
 * 
 */
package com.manning.sdmia.test;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.directory.dao.ContactDao;

/**
 * @author acogoluegnes
 *
 */
public class ContactDaoBlueprintIntegrationTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testGetContacts() throws Exception {
		Thread.sleep(1000); // wait for blueprint container init
		ServiceReference sr = bundleContext.getServiceReference(ContactDao.class.getName());
		Assert.assertNotNull("no ContactDao in the registry",sr);
		ContactDao contactDao = (ContactDao) bundleContext.getService(sr);
		Assert.assertEquals(1,contactDao.getContacts().size());
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.appb.directory, directory.domain, 1.0.0",
			"com.manning.sdmia.appb.directory, directory.dao, 1.0.0",
			"com.manning.sdmia.appb.directory, directory.dao.jdbc, 1.0.0",
			"com.manning.sdmia.appb.directory, directory.datasource.blueprint, 1.0.0",
			"org.springframework, spring-jdbc, "+getSpringVersion(),
			"org.springframework, spring-tx, "+getSpringVersion(),
			"com.h2database, h2, 1.1.119"
		};
	}
	
}
