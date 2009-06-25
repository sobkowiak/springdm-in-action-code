/**
 * 
 */
package com.manning.sdmia.osgi.services.consuming;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.manning.sdmia.osgi.services.providing.service.SimpleService;

/**
 * @author ttemplier
 *
 */
public class ServicesTrackerConsumingActivator implements BundleActivator {

	private void useSimpleServiceUsingTracker(BundleContext bundleContext) {
		String serviceName = "com.manning.sdmia.osgi.services.providing.service.SimpleService";

		ServiceTracker serviceTracker = null;
		try {
			serviceTracker = new ServiceTracker(
									bundleContext, serviceName, null);
			serviceTracker.open();
			SimpleService service
						= (SimpleService) serviceTracker.getService();
			String ret = service.test("param");
			System.out.println("Method test of service com.manning.osgi.simple.service.SimpleService called.");
			System.out.println("- return is: " + ret);
		} catch(Exception ex) {
		    ex.printStackTrace();
		} finally {
			if (serviceTracker!=null) {
				serviceTracker.close();
			}
		}
	}

	public void start(BundleContext bundleContext) throws Exception {
		useSimpleServiceUsingTracker(bundleContext);
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
