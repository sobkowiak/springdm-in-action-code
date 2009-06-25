/**
 * 
 */
package com.manning.sdmia.osgi.services.providing.service.impl;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

/**
 * @author ttemplier
 *
 */
public class SimpleServiceFactoryImpl implements ServiceFactory {

	public Object getService(Bundle bundle, ServiceRegistration registration) {
    	String bundleSymbolicName = bundle.getSymbolicName();
    	if (bundleSymbolicName.startsWith("com.manning")) {
    		return new SimpleForManningServiceImpl();
    	} else {
    		return new SimpleServiceImpl();
    	}
	}

	public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
	}
}
