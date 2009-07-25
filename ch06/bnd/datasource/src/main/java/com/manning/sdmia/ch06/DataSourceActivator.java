/**
 * 
 */
package com.manning.sdmia.ch06;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author acogoluegnes
 *
 */
public class DataSourceActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		try {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUrl("jdbc:h2:tcp://localhost/sdmia-osgify-dbcp");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			System.out.println("getting connection");
			Connection connection = dataSource.getConnection();
			System.out.println(
				"connected to server "+connection.getMetaData().getDatabaseProductName()
			);
			System.out.println("closing connection");
			connection.close();
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		
	}
	
}
