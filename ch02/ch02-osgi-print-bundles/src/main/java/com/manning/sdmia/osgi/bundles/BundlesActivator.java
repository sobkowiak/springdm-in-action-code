/**
 * 
 */
package com.manning.sdmia.osgi.bundles;

import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

/**
 * @author ttemplier
 *
 */
public class BundlesActivator implements BundleActivator {

	private void printFrameworkInformation(BundleContext bundleContext) {
		String containerName
        		= bundleContext.getProperty(Constants.FRAMEWORK_VENDOR);
		String containerVersion
				= bundleContext.getProperty(Constants.FRAMEWORK_VERSION);
		System.out.println("");
		System.out.println("-- Framework information ------------------------");
		System.out.println("Container: " + containerName + ", " + containerVersion);

		String usedLanguage
				= bundleContext.getProperty(Constants.FRAMEWORK_LANGUAGE);
		System.out.println("Used language: " + usedLanguage);

		String osName
				= bundleContext.getProperty(Constants.FRAMEWORK_OS_NAME);
		String osVersion
				= bundleContext.getProperty(Constants.FRAMEWORK_OS_VERSION);
		System.out.println("Operating system: " + osName + ", " + osVersion);

		System.out.println("-------------------------------------------------");
	}
	
	private void printBundleInformation(Bundle bundle) {
		Long bundleId = bundle.getBundleId();
		String location = bundle.getLocation();
		String symbolicName = bundle.getSymbolicName();

		System.out.println("-- " + symbolicName);
		System.out.println(" id: " + bundleId);
		System.out.println(" symbolic name: " + symbolicName);
		System.out.println(" location: " + location);
		
		Dictionary<String,String> headers = bundle.getHeaders();
		String bundleName = headers.get("Bundle-Name");
		String bundleVersion = headers.get("Bundle-Version");
		System.out.println(" name: " + bundleName);
		System.out.println(" version: " + bundleVersion);

		System.out.println("");
	}

	private void printCurrentBundleSymbolicName(BundleContext bundleContext) {
		Bundle currentBundle = bundleContext.getBundle();
		System.out.println("");
		System.out.println("Current bundle is: " + currentBundle.getSymbolicName()
									+ " (id=" + currentBundle.getBundleId()+ ")");
	}

	private void printListBundles(BundleContext bundleContext) {
		Bundle[] bundles = bundleContext.getBundles();
		System.out.println("");
		System.out.println("Number of installed bundles: " + bundles.length);
		System.out.println("");

		for (Bundle bundle : bundles) {
			printBundleInformation(bundle);
		}
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		printFrameworkInformation(bundleContext);
		printCurrentBundleSymbolicName(bundleContext);
		printListBundles(bundleContext);
	}

	public void stop(BundleContext context) throws Exception {
	}

}
