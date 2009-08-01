/**
 * 
 */
package com.manning.sdmia.ch09;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.osgi.framework.ServiceReference;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.ProxyFactory;

import com.manning.sdmia.aop.OsgiProxyFactory;
import com.manning.sdmia.aspects.SecurityAspect;
import com.manning.sdmia.business.BusinessService;
import com.manning.sdmia.business.impl.BusinessServiceImpl;

/**
 * @author acogoluegnes
 *
 */
public class ChainedClassLoaderPatternTest extends AbstractOsgiTest {
	
	public void testChainedClassLoaderPattern() {
		ServiceReference ref = bundleContext.getServiceReference(OsgiProxyFactory.class.getName());
		OsgiProxyFactory proxyFactory = (OsgiProxyFactory) bundleContext.getService(ref);
		
		SecurityAspect aspect = new SecurityAspect();
		
		BusinessService service = (BusinessService) proxyFactory.createProxy(
			new BusinessServiceImpl(),
			aspect,
			BusinessService.class
		);
		
		Assert.assertEquals(0,aspect.getCount());
		service.getAnswer();
		Assert.assertEquals(1,aspect.getCount());
		service.getAnswer();
		Assert.assertEquals(2,aspect.getCount());
	}

	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia.ch09, chained.classloader.target, 1.0.0",
			"com.manning.sdmia.ch09, chained.classloader.aspects, 1.0.0",
			"com.manning.sdmia.ch09, chained.classloader.service, 1.0.0"
		};
	}
	
}
