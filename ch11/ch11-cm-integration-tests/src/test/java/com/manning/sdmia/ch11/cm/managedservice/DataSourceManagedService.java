package com.manning.sdmia.ch11.cm.managedservice;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

import com.manning.sdmia.ch11.cm.placeholder.MockDataSource;

public class DataSourceManagedService implements ManagedService {
	private MockDataSource dataSource = new MockDataSource();

	public void updated(Dictionary properties) throws ConfigurationException {
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
