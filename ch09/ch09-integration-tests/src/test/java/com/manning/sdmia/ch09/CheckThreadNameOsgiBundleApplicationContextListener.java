/**
 * 
 */
package com.manning.sdmia.ch09;

import org.springframework.osgi.context.event.OsgiBundleApplicationContextEvent;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;

/**
 * @author acogoluegnes
 *
 */
public class CheckThreadNameOsgiBundleApplicationContextListener implements OsgiBundleApplicationContextListener {
	
	private String callingThread = null;

	@Override
	public void onOsgiApplicationEvent(OsgiBundleApplicationContextEvent evt) {
		callingThread = Thread.currentThread().getName();		
	}
	
	public String getCallingThread() {
		return callingThread;
	}
	
}
