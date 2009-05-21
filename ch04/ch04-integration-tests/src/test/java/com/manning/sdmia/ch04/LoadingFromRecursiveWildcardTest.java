/**
 * 
 */
package com.manning.sdmia.ch04;

import java.util.Arrays;
import java.util.Collection;
import java.util.jar.Manifest;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.context.ApplicationContext;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * Checks context files are taken with a recursive directory wildcard pattern.
 * @author acogoluegnes
 */
public class LoadingFromRecursiveWildcardTest extends
		AbstractConfigurableBundleCreatorTests {

	public void testLoadBundle() throws Exception {
		ServiceReference [] refs = bundleContext.getAllServiceReferences(ApplicationContext.class.getName(), null);
		// expected bean names in the context
		Collection<String> expectedNames = Arrays.asList("daoDummy","serviceDummy","boDummy","foDummy");
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

	/*
	 * (non-Javadoc)
	 * @see org.springframework.osgi.test.AbstractOnTheFlyBundleCreatorTests#getManifest()
	 */
	protected Manifest getManifest() {
		// let the testing framework create/load the manifest
		Manifest mf = super.getManifest();
		mf.getMainAttributes().putValue("Spring-Context",
				"/com/manning/sdmia/ch04/wildcard/**/*.xml");
		return mf;
	}

}
