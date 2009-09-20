/**
 * 
 */
package com.manning.sdmia.ch10.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.manning.sdmia.ch10.dao.ContactDao;
import com.manning.sdmia.ch10.dao.jdbc.ContactDaoJdbc;

/**
 * @author acogoluegnes
 *
 */
public class DirectoryDaoBundleActivatorSimple implements BundleActivator {
	
	private ServiceRegistration serviceRegistrationDao;

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		serviceRegistrationDao = bundleContext.registerService(
			ContactDao.class.getName(),
			new ContactDaoJdbc(),
			null
		);
	}

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		serviceRegistrationDao.unregister();
	}

}
