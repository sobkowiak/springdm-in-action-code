/**
 * 
 */
package com.manning.sdmia.ch04;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public abstract class AbstractTest extends AbstractConfigurableBundleCreatorTests {

	@Override
	protected Resource getTestingFrameworkBundlesConfiguration() {
		return new InputStreamResource(
				AbstractTest.class.getResourceAsStream("boot-bundles.properties"));
	}	
	
}
