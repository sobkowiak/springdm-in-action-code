/**
 * 
 */
package com.manning.sdmia.osgi.events;

import org.osgi.framework.SynchronousBundleListener;

/**
 * @author ttemplier
 *
 */
public class SampleSynchronousBundleListener extends AbstractBundleListener
										implements SynchronousBundleListener {

	protected boolean isSynchronous() {
		return true;
	}

}
