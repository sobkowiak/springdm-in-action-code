/**
 * 
 */
package com.manning.sdmia.osgi.nativecode;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author ttemplier
 *
 */
public class NativeCodeActivator implements BundleActivator {

	private void callNativeMethod() {
		Calculator calculator = new Calculator();
		System.out.println("1 + 1 = " + calculator.add(1, 1));
	}

	public void start(BundleContext bundleContext) throws Exception {
		callNativeMethod();
	}

	public void stop(BundleContext bundleContext) throws Exception {
	}

}
