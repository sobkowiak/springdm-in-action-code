/**
 * 
 */
package com.manning.sdmia.directory.test.content;

import java.util.Enumeration;

import junit.framework.Assert;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public class DeclarativeSettingLocationContentTest extends AbstractConfigurableBundleCreatorTests {

	public void testVisibleClasses() {
		Contact.class.getName();
		Enumeration<?> logs = bundleContext.getBundle().findEntries("/", "log4j.properties", false);
		Assert.assertNull("properties are not included",logs);
	}	
	
	@Override
	protected String getSettingsLocation() {
		return "/com/manning/sdmia/directory/test/content/DeclarativeTest-bundle.properties";
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.ch10, directory-domain, 1.0.0"
		};
	}
	
	@Override
	protected Resource getTestingFrameworkBundlesConfiguration() {
		return new InputStreamResource(
				getClass().getResourceAsStream("/com/manning/sdmia/directory/test/boot-bundles.properties"));
	}
	
}
