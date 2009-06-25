/**
 * 
 */
package com.manning.sdmia.osgi.events;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author ttemplier
 *
 */
public class EventsActivator implements BundleActivator {
	private SampleBundleListener sampleBundleListener;
	private SampleSynchronousBundleListener sampleSynchronousBundleListener;
	private SampleServiceListener sampleServiceListener;

	public void start(BundleContext context) throws Exception {
		// Initializing and registering listeners
		
		// Sample asynchronous bundle listener
		sampleBundleListener = new SampleBundleListener();
		context.addBundleListener(sampleBundleListener);

		// Sample synchronous bundle listener
		sampleSynchronousBundleListener = new SampleSynchronousBundleListener();
		context.addBundleListener(sampleSynchronousBundleListener);

		// Sample service listener
		sampleServiceListener = new SampleServiceListener();
		context.addServiceListener(sampleServiceListener);
	}

	public void stop(BundleContext context) throws Exception {
		// Unregistering listeners
		
		if (sampleBundleListener!=null) {
			context.removeBundleListener(sampleBundleListener);
		}
		if (sampleSynchronousBundleListener!=null) {
			context.removeBundleListener(sampleSynchronousBundleListener);
		}
		if (sampleServiceListener!=null) {
			context.removeServiceListener(sampleServiceListener);
		}
	}
}
