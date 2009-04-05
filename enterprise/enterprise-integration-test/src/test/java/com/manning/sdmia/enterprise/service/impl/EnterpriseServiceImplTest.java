package com.manning.sdmia.enterprise.service.impl;

import java.util.List;
import java.util.jar.Manifest;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

import com.manning.sdmia.enterprise.dao.UserDao;
import com.manning.sdmia.enterprise.domain.User;
import com.manning.sdmia.enterprise.service.UserService;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseServiceImplTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {		
		
		ServiceReference serviceRef = bundleContext.getServiceReference(UserService.class.getName());
		assertNotNull("Service Reference is null");
		UserService service = (UserService) bundleContext.getService(serviceRef);
		assertNotNull("Cannot find the service",service);
		List<User> users = service.getUsers();
		assertEquals(3,users.size());
		for(User user : users) {
			System.out.println(user.getId());
		}
		
		
	}
	
	protected Manifest getManifest() {
	      Manifest mf = super.getManifest();
	      mf.getMainAttributes().putValue(Constants.IMPORT_PACKAGE, 
	    		  mf.getMainAttributes().getValue(Constants.IMPORT_PACKAGE)+
	    		  ", "+UserService.class.getPackage().getName()+
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
				"com.manning.sdmia.enterprise, enterprise-service, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-service-impl, 1.0-SNAPSHOT"	
		};
	}
	
	
	
}
