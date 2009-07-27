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

	
	public boolean matches(BundleContext bundleContext) {
		return bundleContext.getBundle().getSymbolicName().startsWith("com.manning.sdmia.ch09");
	}

}
