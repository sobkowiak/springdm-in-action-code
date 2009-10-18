/**
 * 
 */
package com.manning.sdmia.appb.directory.datasource;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author acogoluegnes
 *
 */
public class DatabaseInitializer {

	public DatabaseInitializer(DataSource ds) {
		JdbcTemplate tpl = new JdbcTemplate(ds);
		tpl.batchUpdate(new String[] {
			"drop sequence if exists seq_directory_contact_idcontact",
			"drop table if exists directory_contact",
			"create sequence seq_directory_contact_idcontact start with 1 increment by 1",
			"create table directory_contact(idcontact integer not null, firstname varchar(255), lastname varchar(255), primary key (idcontact))",
			"insert into directory_contact (idcontact,firstname,lastname) values (NEXT VALUE FOR seq_directory_contact_idcontact,'arnaud','cogoluegnes')"
		});		
	}
	
}
