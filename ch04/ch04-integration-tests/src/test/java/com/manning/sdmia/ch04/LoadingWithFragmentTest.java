/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.context.ApplicationContext;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * Checks context files are taken from host and fragment bundles.
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
			String [] names = context.getBeanDefinitionNames();
			if(names.length == expectedNames.size()) {
				if(Arrays.asList(names).containsAll(expectedNames)) {
					found = true;
				}
			}
		}
		Assert.assertTrue("Could not find all the expected bean in the context", found);
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia, ch04-load-host-bundle, 1.0-SNAPSHOT",	
			"com.manning.sdmia, ch04-load-fragment-bundle, 1.0-SNAPSHOT"
		};
	}

}
