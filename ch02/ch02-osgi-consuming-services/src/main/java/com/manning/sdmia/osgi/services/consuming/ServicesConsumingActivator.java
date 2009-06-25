/**
 * 
 */
package com.manning.sdmia.osgi.services.consuming;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.manning.sdmia.osgi.services.providing.service.SimpleService;

/**
 * @author ttemplier
 *
 */
public class ServicesConsumingActivator implements BundleActivator {

	private void useSimpleService(BundleContext bundleContext) {
		String serviceName = "com.manning.sdmia.osgi.services.providing.service.SimpleService";

		ServiceReference serviceReference = null;
		try {
			serviceReference = bundleContext.getServiceReference(serviceName);
			if (serviceReference!=null) {
				SimpleService service
						= (SimpleService)bundleContext.getService(serviceReference);
				System.out.println("Reference to service com.manning.osgi.simple.service.SimpleService obtained.");
				String ret = service.test("param");
				System.out.println("Method test of service com.manning.osgi.simple.service.SimpleService called.");
				System.out.println("- return is: " + ret);
			} else {
				System.out.println("Cannot obtain reference to service com.manning.osgi.simple.service.SimpleService.");
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (serviceReference!=null) {
				bundleContext.ungetService(serviceReference);
			}
		}
	}

	public void start(BundleContext bundleContext) throws Exception {
		useSimpleService(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
