/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.jar.Manifest;

/**
 * 
 * @author acogoluegnes
 */
public class LoadingTimeoutTest extends AbstractTest {

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
			"/com/manning/sdmia/ch04/LoadingTimeoutTest-context.xml;timeout:=120");
		return mf;
	}

}
