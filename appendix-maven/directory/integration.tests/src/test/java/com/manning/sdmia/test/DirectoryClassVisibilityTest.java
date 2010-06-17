/**
 * 
 */
package com.manning.sdmia.test;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.directory.dao.ContactDao;
import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public class DirectoryClassVisibilityTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testVisibleClasses() {
		Contact.class.getName();
		ContactDao.class.getName();
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.appb.directory, directory.domain, 1.0.0",
			"com.manning.sdmia.appb.directory, directory.dao, 1.0.0"
		};
	}
	
	@Override
	protected Resource getTestingFrameworkBundlesConfiguration() {
		return new InputStreamResource(
				DirectoryClassVisibilityTest.class.getResourceAsStream("boot-bundles.properties"));
	}
	
}
