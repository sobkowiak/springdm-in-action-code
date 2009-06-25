/**
 * 
 */
package com.manning.sdmia.osgi.services.providing;

import java.util.Date;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.manning.sdmia.osgi.services.providing.service.impl.SimpleServiceFactoryImpl;

/**
 * @author ttemplier
 *
 */
public class FactoryServicesProvidingActivator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    private void registerService(BundleContext bundleContext) {
    	System.out.println("Registering service com.manning.sdmia.osgi.services.providing.service.SimpleService.");
        String serviceName
        			= "com.manning.sdmia.osgi.services.providing.service.SimpleService";
        SimpleServiceFactoryImpl serviceFactory = new SimpleServiceFactoryImpl();
        Properties serviceProperties = new Properties();
        serviceProperties.setProperty("creationDate",
                        (new Date()).toString());
        this.serviceRegistration = bundleContext.registerService(
        				serviceName, serviceFactory, serviceProperties);
	}

    public void start(BundleContext bundleContext) throws Exception {
    	registerService(bundleContext);
    }

    private void unregisterService(BundleContext bundleContext) {
    	System.out.println("Unregistering service com.manning.sdmia.osgi.services.providing.service.SimpleService.");
        if (this.serviceRegistration!=null) {
            this.serviceRegistration.unregister();
        }
    }

    public void stop(BundleContext bundleContext) throws Exception {
    	unregisterService(bundleContext);
    }
}
