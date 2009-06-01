/**
 * 
 */
package com.manning.sdmia.ch04;

import junit.framework.Assert;

import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 * 
 */
public class BundleTagTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testBundleContextAwareTest() throws Exception {
		// a reference to a already installed bundle, Spring DM extender bundle
		Bundle springDmExtenderBundle = (Bundle) applicationContext.getBean("springDmExtenderBundle");
		Assert.assertEquals("we're looking for Spring DM extender bundle and it's not there!",
				"org.springframework.osgi.extender",springDmExtenderBundle.getSymbolicName());	
		
		// a bundle started by Spring DM
		Bundle bundle = (Bundle) applicationContext.getBean("simpleBundle");
		Assert.assertEquals("bundle should have been started through XML configuration",Bundle.ACTIVE,bundle.getState());		
		
	}	
	
	@Override
	protected String[] getConfigPaths() {
		return new String [] {"/com/manning/sdmia/ch04/BundleTagTest-context.xml"};
	}

}
