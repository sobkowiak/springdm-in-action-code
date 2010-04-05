/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.jar.Manifest;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.context.ApplicationContext;

/**
 * @author acogoluegnes
 * 
 */
public class LoadingFromFileSystemTest extends AbstractTest {

	public void testLoadBundle() throws Exception {
		// waits for the app context is loaded properly in another thread
		Thread.sleep(1000);
		ServiceReference [] refs = bundleContext.getAllServiceReferences(ApplicationContext.class.getName(), null);
		boolean found = false;
		for(ServiceReference ref: refs) {
			ApplicationContext context = (ApplicationContext) bundleContext.getService(ref);
			if(context.containsBean("dummy") && context.getBean("dummy") instanceof DummyBean) {
				found = true;
			}
		}
		Assert.assertTrue("Could not find the dummy bean in any context", found);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.osgi.test.AbstractOnTheFlyBundleCreatorTests#getManifest()
	 */
	protected Manifest getManifest() {
		// let the testing framework create/load the manifest
		Manifest mf = super.getManifest();
		mf.getMainAttributes().putValue("Spring-Context",
				"file:src/test/resources/com/manning/sdmia/ch04/SpringContextHeaderTest-context.xml");
		return mf;
	}

}
