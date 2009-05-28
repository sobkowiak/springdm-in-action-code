/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.jar.Manifest;

import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * 
 * @author acogoluegnes
 */
public class LoadingNoWaitingForDepsTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testLoadSync() throws Exception {
		Thread.sleep(500);
		// nothing much to do actually!
		// can check the TRACE level of ApplicationContextConfiguration to check are directives are properly set
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.osgi.test.AbstractOnTheFlyBundleCreatorTests#getManifest()
	 */
	protected Manifest getManifest() {
		// let the testing framework create/load the manifest
		Manifest mf = super.getManifest();
		mf.getMainAttributes().putValue("Spring-Context",
			"/com/manning/sdmia/ch04/LoadingNoWaitingForDepsTest-context.xml;wait-for-dependencies:=false");
		return mf;
	}

}
