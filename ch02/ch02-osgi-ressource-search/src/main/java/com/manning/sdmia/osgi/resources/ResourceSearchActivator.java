/**
 * 
 */
package com.manning.sdmia.osgi.resources;

import java.net.URL;
import java.util.Enumeration;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author ttemplier
 *
 */
public class ResourceSearchActivator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		Bundle[] bundles = bundleContext.getBundles();
		
		for (Bundle bundle : bundles) {
			searchResources(bundle);
		}
	}

	private void searchResources(Bundle bundle) {
		System.out.println("");
		System.out.println("-- " + bundle.getSymbolicName());
		
		System.out.println(" Trying to load resource META-INF/spring/osgi-context.xml...");
		URL specificConfigurationFile = bundle.getResource(
							"META-INF/spring/osgi-context.xml");
		if (specificConfigurationFile==null) {
			System.out.println(" No file META-INF/spring/osgi-context.xml.");
		} else {
			System.out.println(" File osgi-context.xml found in the directory META-INF/spring.");
		}

		System.out.println(" Searching XML files in the directory META-INF/spring...");
		Enumeration configurationFiles = bundle.findEntries(
							"META-INF/spring", "*.xml", false);
		if (configurationFiles==null) {
			System.out.println(" No result.");
		} else {
			System.out.println(" Result(s):");
			for (; configurationFiles.hasMoreElements();) {
				URL fileUrl = (URL) configurationFiles.nextElement();
				String filename = fileUrl.getFile();
				System.out.println(" - " + filename);
			}
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
