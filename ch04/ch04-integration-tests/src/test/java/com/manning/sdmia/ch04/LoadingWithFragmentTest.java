/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * Checks context files are taken from host and fragment bundles, some resource loading test.
 * @author acogoluegnes
 */
public class LoadingWithFragmentTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testLoadBundle() throws Exception {
		ServiceReference [] refs = bundleContext.getAllServiceReferences(ApplicationContext.class.getName(), null);
		// expected bean names in the context
		Collection<String> expectedNames = Arrays.asList("hostDummy","fragmentDummy");
		boolean found = false;
		for(ServiceReference ref: refs) {
			ApplicationContext context = (ApplicationContext) bundleContext.getService(ref);
			if(context.getDisplayName().contains("com.manning.sdmia.ch04-load-host-bundle")) {
				String [] names = context.getBeanDefinitionNames();
				if(names.length == expectedNames.size()) {
					if(Arrays.asList(names).containsAll(expectedNames)) {
						found = true;
					}
				}
			}

		}
		Assert.assertTrue("Could not find all the expected bean in the context", found);
	}
	
	public void testLoadResources() throws Exception {
		ServiceReference [] refs = bundleContext.getAllServiceReferences(ApplicationContext.class.getName(), null);
		// expected bean names in the context
		for(ServiceReference ref: refs) {
			ApplicationContext context = (ApplicationContext) bundleContext.getService(ref);
			if(context.getDisplayName().contains("com.manning.sdmia.ch04-load-host-bundle")) {
				// resource in bundle itself
				// default search in bundle space
				Resource res = context.getResource("help/section1.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				// explicit
				res = context.getResource("osgibundle:help/section1.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				// just in the bundle
				res = context.getResource("osgibundlejar:help/section1.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				// class space
				res = context.getResource("classpath:help/section1.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				
				// resource in fragment
				// default search in bundle space
				res = context.getResource("help/section2.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				// explicit
				res = context.getResource("osgibundle:help/section2.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				// just in the bundle, should not find it
				res = context.getResource("osgibundlejar:help/section2.html");
				Assert.assertNotNull(res);
				Assert.assertFalse(res.exists());
				// class space, use the bundle classloader, should find it
				res = context.getResource("classpath:help/section2.html");
				Assert.assertNotNull(res);
				Assert.assertTrue(res.exists());
				
			}			
		}
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia, ch04-load-host-bundle, 1.0-SNAPSHOT",	
			"com.manning.sdmia, ch04-load-fragment-bundle, 1.0-SNAPSHOT"
		};
	}

}
