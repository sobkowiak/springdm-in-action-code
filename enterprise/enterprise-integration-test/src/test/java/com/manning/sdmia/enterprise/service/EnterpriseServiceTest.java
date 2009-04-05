package com.manning.sdmia.enterprise.service;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseServiceTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {		
		boolean bundleIsThere = false;
		for(Bundle currentBundle : bundleContext.getBundles()) {
			if("com.manning.sdmia.enterprise.service".equals(currentBundle.getSymbolicName())) {
				bundleIsThere = true;
				break;
			}			
		}
		assertTrue("enterprise service bundle does not seem to be installed!",bundleIsThere);
		
	}
	

	
	
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia.enterprise, enterprise-domain, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-dao, 1.0-SNAPSHOT",	
				"com.manning.sdmia.enterprise, enterprise-dao-simple, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-service, 1.0-SNAPSHOT"
		};
	}
	
	
	
}
