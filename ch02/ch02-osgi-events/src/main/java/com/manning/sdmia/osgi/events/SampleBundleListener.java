/**
 * 
 */
package com.manning.sdmia.osgi.events;

import org.osgi.framework.BundleListener;

/**
 * @author ttemplier
 *
 */
public class SampleBundleListener extends AbstractBundleListener implements BundleListener {

	protected boolean isSynchronous() {
		return false;
	}

}
