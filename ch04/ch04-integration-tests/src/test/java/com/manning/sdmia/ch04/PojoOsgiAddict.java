/**
 * 
 */
package com.manning.sdmia.ch04;

import org.osgi.framework.BundleContext;

/**
 * @author acogoluegnes
 *
 */
public class PojoOsgiAddict {
	
	private BundleContext bundleContext;

	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;	
	}
	
	public BundleContext getBundleContext() {
		return bundleContext;
	}
	
}
