/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.jar.Manifest;

import junit.framework.Assert;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.springframework.context.ApplicationContext;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public class ExtenderEventsTest extends
		AbstractConfigurableBundleCreatorTests {

	/** just to import automatically the package */
	private OsgiBundleApplicationContextListener listener;
	
	public void testLoadBundle() throws Exception {		
		// waits for the app context is loaded properly in another thread
		Thread.sleep(1000);
		// needs to find the spring-powered bundle
		Bundle springBundle = null;
		Bundle testBundle = null;
		for(Bundle bundle : bundleContext.getBundles()) {
			if("com.manning.sdmia.ch04-springbundle-wp".equals(bundle.getSymbolicName())) {
				springBundle = bundle;
			} else if("TestBundle-testLoadBundle-com.manning.sdmia.ch04.ExtenderEventsTest".equals(bundle.getSymbolicName())) {
				testBundle = bundle;
			}
		}
//		System.out.println("STAAAAAAAAAAAAART");
		Assert.assertNotNull("cannot find spring-powered bundle",springBundle);
		Assert.assertNotNull("cannot find test bundle", testBundle);
		// stops the bundle
		springBundle.stop();
		// waits a little to stop and propagate events
		Thread.sleep(500);
		// start the bundle again
		springBundle.start();
		// waits a little to stop and propagate events
		Thread.sleep(500);
		
		ServiceReference[] appContexts = bundleContext.getServiceReferences(ApplicationContext.class.getName(), null);
		ApplicationContext testAppContext = null;
		for(ServiceReference ref : appContexts) {
			if("TestBundle-testLoadBundle-com.manning.sdmia.ch04.ExtenderEventsTest".equals(ref.getBundle().getSymbolicName())) {
				testAppContext = (ApplicationContext) bundleContext.getService(ref);
				break;
			}
		}
		Assert.assertNotNull("cannot find test application context",testAppContext);
		ApplicationContextObserver observer = (ApplicationContextObserver) testAppContext.getBean("observer");
		// started twice
		Assert.assertEquals(2, observer.getCountRefreshed());
		// stopped once
		Assert.assertEquals(1, observer.getCountClosed());
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.osgi.test.AbstractOnTheFlyBundleCreatorTests#getManifest()
	 */
	protected Manifest getManifest() {
		// let the testing framework create/load the manifest
		Manifest mf = super.getManifest();
		mf.getMainAttributes().putValue("Spring-Context",
				"file:src/test/resources/com/manning/sdmia/ch04/ExtenderEventsTest-context.xml");
		return mf;
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia, ch04-springbundle-wp, 1.0-SNAPSHOT"
		};
	}
}
