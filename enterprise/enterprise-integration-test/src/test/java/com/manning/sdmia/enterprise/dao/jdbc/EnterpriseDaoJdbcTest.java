package com.manning.sdmia.enterprise.dao.jdbc;

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
public class EnterpriseDaoJdbcTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() {		
		
		ServiceReference serviceRef = bundleContext.getServiceReference(UserDao.class.getName());
		assertNotNull("Service Reference is null",serviceRef);
		UserDao dao = (UserDao) bundleContext.getService(serviceRef);
		assertNotNull("Cannot find the DAO",dao);
		List<User> users = dao.getUsers();
		assertEquals(1,users.size());
		for(User user : users) {
			System.out.println(user.getId());
		}
		
		for(Bundle currentBundle : bundleContext.getBundles()) {
			System.out.println(currentBundle.getSymbolicName()+" "+currentBundle.getState());
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
				"com.manning.sdmia.enterprise, enterprise-dao-jdbc, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-datasource, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-c3p0-config, 1.0-SNAPSHOT",
				"com.mchange.c3p0, com.springsource.com.mchange.v2.c3p0, 0.9.1.2",
				"org.hsqldb, com.springsource.org.hsqldb, 1.8.0.9",
				"org.springframework, spring-jdbc, 2.5.6",
				"org.springframework, spring-tx, 2.5.6"
		};
	}
	
	
	
}
