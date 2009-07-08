/**
 * 
 */
package com.manning.sdmia.ch09;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 * 
 */
public class ConfigureStandardExtenderTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testConfigureExtender() {
		for (Bundle bundle : bundleContext.getBundles()) {
			System.out.println(bundle.getSymbolicName());
		}
	}

	@Override
	protected String[] getTestBundlesNames() {
		return new String[] {
			"com.manning.sdmia.ch09, standard-extender-configuration, 1.0.0.SNAPSHOT",
			"edu.emory.mathcs.backport, com.springsource.edu.emory.mathcs.backport, 3.1.0"
		};
	}

}
