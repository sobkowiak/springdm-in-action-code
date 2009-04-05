package com.manning.sdmia.enterprise.dao.simple;

import java.util.List;
import java.util.jar.Manifest;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.enterprise.dao.UserDao;
import com.manning.sdmia.enterprise.domain.User;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseDaoSimpleTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {		
		
		ServiceReference serviceRef = bundleContext.getServiceReference(UserDao.class.getName());
		assertNotNull("Service Reference is null");
		UserDao dao = (UserDao) bundleContext.getService(serviceRef);
		assertNotNull("Cannot find the DAO",dao);
		List<User> users = dao.getUsers();
		assertEquals(3,users.size());
		for(User user : users) {
			System.out.println(user.getId());
		}
		
		for(Bundle currentBundle : bundleContext.getBundles()) {
			System.out.println(currentBundle.getSymbolicName());
		}
		
	}
	
	protected Manifest getManifest() {
	      Manifest mf = super.getManifest();
	      mf.getMainAttributes().putValue(Constants.IMPORT_PACKAGE, 
	    		  mf.getMainAttributes().getValue(Constants.IMPORT_PACKAGE)+
	    		  ", "+UserDao.class.getPackage().getName()+
	    		  ", "+User.class.getPackage().getName()
	      );
	      return mf;
	}
	
	
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia.enterprise, enterprise-domain, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-dao, 1.0-SNAPSHOT",	
				"com.manning.sdmia.enterprise, enterprise-dao-simple, 1.0-SNAPSHOT",
		};
	}
	
	
	
}
