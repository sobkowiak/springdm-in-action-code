/**
 * 
 */
package com.manning.sdmia.directory.test;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;
import org.springframework.osgi.test.platform.Platforms;

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
	
}
