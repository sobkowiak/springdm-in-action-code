package com.manning.sdmia.enterprise.dao;

import javax.sql.DataSource;

import org.osgi.framework.ServiceReference;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * 
 * @author acogoluegnes
 *
 */
public class EnterpriseDataSourceTest extends AbstractConfigurableBundleCreatorTests {

	public void testIntegration() throws Exception {		
		ServiceReference serviceRef = bundleContext.getServiceReference(DataSource.class.getName());
		assertNotNull("service reference is null",serviceRef);
		DataSource ds = (DataSource) bundleContext.getService(serviceRef);
		
		JdbcTemplate tpl = new JdbcTemplate(ds);
		
		tpl.queryForInt("select count(1) from enterprise_user");		
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
				"com.manning.sdmia.enterprise, enterprise-datasource, 1.0-SNAPSHOT",
				"com.manning.sdmia.enterprise, enterprise-c3p0-config, 1.0-SNAPSHOT",
				"com.mchange.c3p0, com.springsource.com.mchange.v2.c3p0, 0.9.1.2",
				"org.hsqldb, com.springsource.org.hsqldb, 1.8.0.9",
				"org.springframework, spring-jdbc, 2.5.6",
				"org.springframework, spring-tx, 2.5.6"
		};
	}
	
}
