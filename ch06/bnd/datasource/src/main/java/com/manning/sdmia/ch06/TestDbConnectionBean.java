/**
 * 
 */
package com.manning.sdmia.ch06;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author acogoluegnes
 *
 */
public class TestDbConnectionBean {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void init() {
		try {
			System.out.println("getting connection");
			Connection connection = dataSource.getConnection();
			System.out.println(
				"connected to server "+connection.getMetaData().getDatabaseProductName()
			);
			System.out.println("closing connection");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
