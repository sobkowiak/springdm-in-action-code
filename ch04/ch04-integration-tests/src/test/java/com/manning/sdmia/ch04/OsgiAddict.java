/**
 * 
 */
package com.manning.sdmia.ch04;

import org.osgi.framework.BundleContext;
import org.springframework.osgi.context.BundleContextAware;

/**
 * @author acogoluegnes
 *
 */
public class OsgiAddict implements BundleContextAware {
	
	private BundleContext bundleContext;

	/*
	 * (non-Javadoc)
	 * @see org.springframework.osgi.context.BundleContextAware#setBundleContext(org.osgi.framework.BundleContext)
	 */
	@Override
	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;	
	}
	
	public BundleContext getBundleContext() {
		return bundleContext;
	}
	
}
