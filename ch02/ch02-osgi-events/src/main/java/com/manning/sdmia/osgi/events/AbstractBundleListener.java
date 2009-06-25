/**
 * 
 */
package com.manning.sdmia.osgi.events;

import org.osgi.framework.BundleEvent;

/**
 * @author ttemplier
 *
 */
public abstract class AbstractBundleListener {

	private String getBundleListenerType() {
		return isSynchronous() ? "[synchronous]" : "[asynchronous]";
	}
	
	protected abstract boolean isSynchronous();
	
	public void bundleChanged(BundleEvent event) {
		int type = event.getType();
		String symbolicName = event.getBundle().getSymbolicName();

        if (type==BundleEvent.STARTED) {
        	System.out.println(getBundleListenerType() + " Bundle " + symbolicName + " started...");
        } else if (type==BundleEvent.STOPPED) {
        	System.out.println(getBundleListenerType() + " Bundle " + symbolicName + " stopped...");
        }
	}

}
