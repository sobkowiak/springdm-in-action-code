/**
 * 
 */
package com.manning.sdmia.ch10.internal;

import javax.sql.DataSource;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.manning.sdmia.ch10.dao.ContactDao;
import com.manning.sdmia.ch10.dao.jdbc.ContactDaoJdbc;

/**
 * @author acogoluegnes
 *
 */
public class DirectoryDaoBundleActivatorWithCondition implements BundleActivator {
	
	private ServiceRegistration serviceRegistrationDao;

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		if(bundleContext.getServiceReference(DataSource.class.getName()) != null) {
			serviceRegistrationDao = bundleContext.registerService(
				ContactDao.class.getName(),
				new ContactDaoJdbc(),
				null
			);
		}		
	}

	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		if(serviceRegistrationDao != null) {
			serviceRegistrationDao.unregister();
		}		
	}

}
