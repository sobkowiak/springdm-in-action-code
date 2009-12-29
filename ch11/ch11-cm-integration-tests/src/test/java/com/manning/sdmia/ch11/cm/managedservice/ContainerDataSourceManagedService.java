package com.manning.sdmia.ch11.cm.managedservice;

import com.manning.sdmia.ch11.cm.placeholder.MockDataSource;

public class ContainerDataSourceManagedService {
	private MockDataSource dataSource = new MockDataSource();

	public String getDriverClassName() {
		return dataSource.getDriverClassName();
	}

	public String getPassword() {
		return dataSource.getPassword();
	}

	public String getUrl() {
		return dataSource.getUrl();
	}

	public String getUsername() {
		return dataSource.getUsername();
	}

	public void setDriverClassName(String driverClassName) {
		dataSource.setDriverClassName(driverClassName);
	}

	public void setPassword(String password) {
		dataSource.setPassword(password);
	}

	public void setUrl(String url) {
		dataSource.setUrl(url);
	}

	public void setUsername(String username) {
		dataSource.setUsername(username);
	}


}
