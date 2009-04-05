package com.manning.sdmia.enterprise.dao;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseDaoTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {		
		boolean domainBundleIsThere = false;
		for(Bundle currentBundle : bundleContext.getBundles()) {
			if("com.manning.sdmia.enterprise.enterprise-domain".equals(currentBundle.getSymbolicName())) {
				domainBundleIsThere = true;
				break;
			}			
		}
		assertTrue("enterprise domain bundle does not seem to be installed!",domainBundleIsThere);
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia.enterprise, enterprise-domain, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-dao, 1.0-SNAPSHOT"				
		};
	}
	
}
