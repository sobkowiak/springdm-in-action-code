/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.jar.Manifest;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.context.ApplicationContext;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * 
 * @author acogoluegnes
 */
public class LoadingNoPublishingTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testLoadSync() throws Exception {
		Thread.sleep(500);
		ServiceReference [] refs = bundleContext.getAllServiceReferences(ApplicationContext.class.getName(), null);
		Assert.assertEquals(1,refs.length);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.osgi.test.AbstractOnTheFlyBundleCreatorTests#getManifest()
	 */
	protected Manifest getManifest() {
		// let the testing framework create/load the manifest
		Manifest mf = super.getManifest();
		mf.getMainAttributes().putValue("Spring-Context",
			"/com/manning/sdmia/ch04/LoadingNoPublishingTest-context.xml;publish-context:=false");
		return mf;
	}

}
