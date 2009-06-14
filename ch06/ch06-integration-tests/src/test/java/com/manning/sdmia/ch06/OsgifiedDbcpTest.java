/**
 * 
 */
package com.manning.sdmia.ch06;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import junit.framework.Assert;

import org.apache.commons.dbcp.BasicDataSource;
import org.osgi.framework.Bundle;
import org.springframework.osgi.test.AbstractConfigurableBundleCreatorTests;

/**
 * @author acogoluegnes
 *
 */
public class OsgifiedDbcpTest extends AbstractConfigurableBundleCreatorTests {
	
	/** Dummy property to dynamically add the import-package */
	private BasicDataSource basicDataSource;

	public void testOsgifiedDbcp() {
		// check commons-pool and commons-dbcp are active
		int countBundleChecked = 0;
		for(Bundle bundle : bundleContext.getBundles()) {
			if("com.manning.sdmia.commons-pool.osgi".equals(bundle.getSymbolicName()) ||
				"com.manning.sdmia.commons-dbcp.osgi".equals(bundle.getSymbolicName())) {
				Assert.assertEquals("OSGified library not activated",Bundle.ACTIVE,bundle.getState());
				countBundleChecked++;
			}			
		}
		int expectedCountBundleChecked = 2;
		Assert.assertEquals(expectedCountBundleChecked+" bundles should have been checked",expectedCountBundleChecked,countBundleChecked);
		
		DataSource dataSource = (DataSource) getApplicationContext().getBean("dataSource");
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Assert.assertTrue(connection.getMetaData().getDatabaseProductName().toLowerCase().contains("hsql"));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
	
	@Override
	protected String[] getTestBundlesNames() {
		return new String [] {
			"com.manning.sdmia, commons-pool.osgi, 1.3.0-SNAPSHOT",
			"com.manning.sdmia, commons-dbcp.osgi, 1.2.2-SNAPSHOT",
			"org.hsqldb, com.springsource.org.hsqldb, 1.8.0.9"
		};
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String [] {"/com/manning/sdmia/ch06/OsgifiedDbcpTest-context.xml"};
	}
	
}
