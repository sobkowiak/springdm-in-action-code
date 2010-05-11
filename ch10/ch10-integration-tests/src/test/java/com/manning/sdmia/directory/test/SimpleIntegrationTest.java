/**
 * 
 */
package com.manning.sdmia.directory.test;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public class SimpleIntegrationTest extends AbstractConfigurableBundleCreatorTests {

	public void testPlatformInfo() {
		System.out.println(
			"Platform is "+
			bundleContext.getProperty(Constants.FRAMEWORK_VENDOR)+
			" "+
			bundleContext.getProperty(Constants.FRAMEWORK_VERSION)
		);
	}
	
	public void testInstalledBundles() {
		for(Bundle bundle : bundleContext.getBundles()) {
			System.out.println(bundle.getSymbolicName());
		}
	}
	
	@Override
	protected Resource getTestingFrameworkBundlesConfiguration() {
		return new InputStreamResource(
				getClass().getResourceAsStream("/com/manning/sdmia/directory/test/boot-bundles.properties"));
	}
	
}
