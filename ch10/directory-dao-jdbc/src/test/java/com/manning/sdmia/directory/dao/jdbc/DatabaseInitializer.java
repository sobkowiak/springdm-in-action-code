/**
 * 
 */
package com.manning.sdmia.directory.dao.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Does init work (creation of tables and sequences) for the database.
 * @author acogoluegnes
 *
 */
public class DatabaseInitializer {

	/**
	 * 
	 * @param ds
	 */
	public DatabaseInitializer(DataSource ds) {
		JdbcTemplate tpl = new JdbcTemplate(ds);
		tpl.batchUpdate(new String[] {
			"drop sequence if exists seq_directory_contact_idcontact",
			"drop table if exists directory_contact",
			"create sequence seq_directory_contact_idcontact start with 1 increment by 1",
			"create table directory_contact(idcontact integer not null, firstname varchar(255), lastname varchar(255), primary key (idcontact))"
		});
		
	}
	
}
