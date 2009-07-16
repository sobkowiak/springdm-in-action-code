/**
 * 
 */
package com.manning.sdmia.ch09;

import junit.framework.Assert;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;
import org.springframework.osgi.extender.OsgiBeanFactoryPostProcessor;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 * 
 */
public class ConfigureStandardExtenderTest extends
		AbstractConfigurableBundleCreatorTests {

	/* for automatic import */
	private OsgiBundleApplicationContextListener dummyListener;
	
	private CheckThreadNameOsgiBundleApplicationContextListener multiCasterChecker;

	public void testConfigureExtender() throws Exception {
		// event multi-caster
		Bundle bundle = findBundle("com.manning.sdmia.ch09.simplebundle");
		Assert.assertNotNull("cannot find bundle for event multi caster test", bundle);
		bundle.stop();
		Thread.sleep(500);
		Assert.assertTrue(multiCasterChecker.getCallingThread().startsWith("OsgiEventMultiCaster-"));
		
		// OSGi bean factory post-processor
		// just count
		Assert.assertEquals(1,bundleContext.getServiceReferences(OsgiBeanFactoryPostProcessor.class.getName(), null).length);
		ServiceReference ref = bundleContext.getServiceReference(OsgiBeanFactoryPostProcessor.class.getName());
		Assert.assertEquals(
			"{com.manning.sdmia.ch09.simplebundle=1}",
			bundleContext.getService(ref).toString()
		);		
	}

	private Bundle findBundle(String symbolicName) {
		for (Bundle bundle : bundleContext.getBundles()) {
			if (bundle.getSymbolicName().equals(symbolicName)) {
				return bundle;
			}
		}
		return null;
	}

	@Override
	protected String[] getTestBundlesNames() {
		return new String[] {
				"com.manning.sdmia.ch09, standard-extender-configuration, 1.0.0.SNAPSHOT",
				"edu.emory.mathcs.backport, com.springsource.edu.emory.mathcs.backport, 3.1.0",
				"com.manning.sdmia.ch09, ch09-simplebundle, 1.0.0.SNAPSHOT" };
	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "/com/manning/sdmia/ch09/ConfigureStandardExtenderTest-context.xml" };
	}
	
	public void setMultiCasterChecker(
			CheckThreadNameOsgiBundleApplicationContextListener multiCasterChecker) {
		this.multiCasterChecker = multiCasterChecker;
	}

}
