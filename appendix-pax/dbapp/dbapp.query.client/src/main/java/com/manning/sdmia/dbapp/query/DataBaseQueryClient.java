/**
 * 
 */
package com.manning.sdmia.dbapp.query;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author acogoluegnes
 *
 */
public class DataBaseQueryClient {

	private DataSource dataSource;
	
	public void init() throws Exception {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		System.out.println("[Database Query Client] contacts: "+template.queryForInt("select count(1) from directory_contact"));

	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
