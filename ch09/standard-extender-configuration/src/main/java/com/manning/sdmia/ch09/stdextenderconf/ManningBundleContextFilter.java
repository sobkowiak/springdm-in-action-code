package com.manning.sdmia.ch09.stdextenderconf;
import org.osgi.framework.BundleContext;
import org.springframework.osgi.extender.support.ConditionalApplicationContextCreator.BundleContextFilter;

/**
 * 
 */

/**
 * @author acogoluegnes
 *
 */
public class ManningBundleContextFilter implements BundleContextFilter {

	/* (non-Javadoc)
	 * @see org.springframework.osgi.extender.support.ConditionalApplicationContextCreator.BundleContextFilter#matches(org.osgi.framework.BundleContext)
	 */
	@Override
	public boolean matches(BundleContext bundleContext) {
		return bundleContext.getBundle().getSymbolicName().startsWith("com.manning.sdmia.ch09");
	}

}
