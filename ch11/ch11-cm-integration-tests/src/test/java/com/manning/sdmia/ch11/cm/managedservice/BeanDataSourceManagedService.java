package com.manning.sdmia.ch11.cm.managedservice;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;

import com.manning.sdmia.ch11.cm.placeholder.MockDataSource;

public class BeanDataSourceManagedService {
	private MockDataSource dataSource = new MockDataSource();

	public void updateDataSourceProperties(Dictionary properties) throws ConfigurationException {
		System.out.println("> updateDataSourceProperties - properties = "+properties);
		if (dataSource!=null && properties!=null) {
			String driverClassName = (String) properties.get("jdbc.driverClassName");
			String url = (String) properties.get("jdbc.url");
			String username = (String) properties.get("jdbc.username");
			String password = (String) properties.get("jdbc.password");

			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
		}
	}

	public MockDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(MockDataSource dataSource) {
		this.dataSource = dataSource;
	}

}
