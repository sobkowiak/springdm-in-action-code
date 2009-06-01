/**
 * 
 */
package com.manning.sdmia.ch04;

import org.springframework.osgi.context.event.
	OsgiBundleApplicationContextEvent;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;
import org.springframework.osgi.context.event.OsgiBundleContextClosedEvent;
import org.springframework.osgi.context.event.OsgiBundleContextRefreshedEvent;

/**
 * @author acogoluegnes
 *
 */
public class ApplicationContextObserver implements
		OsgiBundleApplicationContextListener {

	private transient int countRefreshed = 0;
	private transient int countClosed = 0;
	
	/* (non-Javadoc)
	 * @see org.springframework.osgi.context.event.OsgiBundleApplicationContextListener#onOsgiApplicationEvent(org.springframework.osgi.context.event.OsgiBundleApplicationContextEvent)
	 */
	@Override
	public void onOsgiApplicationEvent(OsgiBundleApplicationContextEvent evt) {
		if(evt instanceof OsgiBundleContextRefreshedEvent) {
			countRefreshed++;
		} else if(evt instanceof OsgiBundleContextClosedEvent) {
			countClosed++;
		}
	}

	public int getCountRefreshed() {
		return countRefreshed;
	}

	public int getCountClosed() {
		return countClosed;
	}

}
