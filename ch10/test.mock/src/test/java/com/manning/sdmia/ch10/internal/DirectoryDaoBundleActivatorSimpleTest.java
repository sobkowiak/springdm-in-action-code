/**
 * 
 */
package com.manning.sdmia.ch10.internal;

import java.util.Dictionary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.springframework.osgi.mock.MockBundleContext;
import org.springframework.osgi.mock.MockServiceRegistration;

import com.manning.sdmia.ch10.dao.ContactDao;

/**
 * @author acogoluegnes
 *
 */
public class DirectoryDaoBundleActivatorSimpleTest {
	
	int daoRegistered;
	
	@Before public void setUp() {
		daoRegistered = 0;
	}

	@Test public void startAndStop() throws Exception {
		BundleContext bundleContext = new MockBundleContext() {

			@Override
			public ServiceRegistration registerService(String clazz,
					Object service, Dictionary properties) {
				if(service instanceof ContactDao) {
					daoRegistered++;
					return new MockServiceRegistration() {
						@Override
						public void unregister() {
							daoRegistered--;
						};
					};
				} else {
					return super.registerService(clazz, service, properties);
				}				
			}
		};
		
		BundleActivator bundleActivator = new DirectoryDaoBundleActivatorSimple();		
		bundleActivator.start(bundleContext);
		Assert.assertEquals(1,daoRegistered);
		bundleActivator.stop(bundleContext);
		Assert.assertEquals(0,daoRegistered);		
	}
	
}
