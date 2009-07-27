/**
 * 
 */
package com.manning.sdmia.ch09.stdextenderconf;

import org.springframework.osgi.context.event.OsgiBundleApplicationContextEvent;
import org.springframework.osgi.context.event.OsgiBundleApplicationContextListener;

/**
 * @author acogoluegnes
 *
 */
public class ConsoleApplicationContextListener implements
		OsgiBundleApplicationContextListener {


	public void onOsgiApplicationEvent(OsgiBundleApplicationContextEvent evt) {
		System.out.println(evt);		
	}

}
