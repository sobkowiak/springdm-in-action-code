/**
 * 
 */
package com.manning.sdmia.osgi.events;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

/**
 * @author ttemplier
 *
 */
public class SampleServiceListener implements ServiceListener {

	 private String getServiceName(ServiceEvent event) {
        String[] objectClass = (String[])
	           event.getServiceReference().getProperty("objectClass");
        return objectClass[0];
    }

    public void serviceChanged(ServiceEvent event) {
        int type = event.getType();
        String serviceName = getServiceName(event);
        String symbolicName = event.getServiceReference().getBundle().getSymbolicName();

        if (type==ServiceEvent.REGISTERED) {
        	System.out.println("Service " + serviceName
            		+ " registred by the bundle " + symbolicName + "...");
        } else if (type==ServiceEvent.UNREGISTERING) {
        	System.out.println("Service " + serviceName
        			+ " being unregistred by the bundle "
        			+ symbolicName + "...");
        } else if (type==ServiceEvent.MODIFIED) {
        	System.out.println("Service " + serviceName
        			+ " modified by the bundle " + symbolicName + "...");
        }
	}
}
