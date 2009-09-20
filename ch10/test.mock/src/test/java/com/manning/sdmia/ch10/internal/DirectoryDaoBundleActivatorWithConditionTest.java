/**
 * 
 */
package com.manning.sdmia.ch10.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.springframework.osgi.mock.MockBundleContext;
import org.springframework.osgi.mock.MockServiceReference;
import org.springframework.osgi.mock.MockServiceRegistration;

import com.manning.sdmia.ch10.dao.ContactDao;

/**
 * @author acogoluegnes
 *
 */
public class DirectoryDaoBundleActivatorWithConditionTest {
	
	int daoRegistered;
	
	@Before public void setUp() {
		daoRegistered = 0;
	}

	@Test public void startAndStopWithDataSource() throws Exception {
		BundleContext bundleContext = new MockBundleContext() {
			@Override
			public ServiceReference getServiceReference(String clazz) {
				return new MockServiceReference();
			}
			@Override
			public ServiceRegistration registerService(String clazz,
					Object service, Dictionary properties) {
				if(service instanceof ContactDao) {
					daoRegistered++;
					return new MockServiceRegistration() {
						public void unregister() {
							daoRegistered--;
						};
					};
				} else {
					return super.registerService(clazz, service, properties);
				}				
			}
		};
		
		BundleActivator bundleActivator = new DirectoryDaoBundleActivatorWithCondition();
		
		bundleActivator.start(bundleContext);
		Assert.assertEquals(1,daoRegistered);
		bundleActivator.stop(bundleContext);
		Assert.assertEquals(0,daoRegistered);
		
	}
	
	@Test public void startAndStopNoDataSource() throws Exception {
		MockBundleContext bundleContext = new MockBundleContext() {
			@Override
			public ServiceReference getServiceReference(String clazz) {
				return null;
			}
			@Override
			public ServiceRegistration registerService(String clazz,
					Object service, Dictionary properties) {
				if(service instanceof ContactDao) {
					daoRegistered++;
					return new MockServiceRegistration() {
						public void unregister() {
							daoRegistered--;
						};
					};
				} else {
					return super.registerService(clazz, service, properties);
				}				
			}
		};
		
		BundleActivator bundleActivator = new DirectoryDaoBundleActivatorWithCondition();
		
		bundleActivator.start(bundleContext);
		Assert.assertEquals(0,daoRegistered);
		bundleActivator.stop(bundleContext);
		Assert.assertEquals(0,daoRegistered);
		
	}
	
}
