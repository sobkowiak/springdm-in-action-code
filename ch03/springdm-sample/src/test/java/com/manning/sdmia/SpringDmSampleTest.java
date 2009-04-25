/**
 * 
 */
package com.manning.sdmia;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public class SpringDmSampleTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {		
		boolean bundleIsHereAndStarted = false;
		for(Bundle currentBundle : bundleContext.getBundles()) {
			if("com.manning.sdmia.springdm-sample".equals(currentBundle.getSymbolicName()) 
					&& currentBundle.getState() == Bundle.ACTIVE) {
				bundleIsHereAndStarted = true;
				break;
			}			
		}
		assertTrue("springdm-sample is not installed nor activated!",bundleIsHereAndStarted);
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia, springdm-sample, 1.0-SNAPSHOT"		
		};
	}
	
}
