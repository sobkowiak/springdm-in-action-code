/**
 * 
 */
package com.manning.sdmia.directory.modular.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.manning.sdmia.directory.dao.ContactDao;
import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public class ContactDaoJdbc extends SimpleJdbcDaoSupport implements ContactDao {
	
	private static final String SQL_SELECT_CONTACTS = "select idcontact,firstname,lastname from directory_contact";
	
	private UserRowMapper userRowMapper = new UserRowMapper();
	
	/*
	 * (non-Javadoc)
	 * @see com.manning.sdmia.directory.dao.ContactDao#getContacts()
	 */
	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = getSimpleJdbcTemplate().query(SQL_SELECT_CONTACTS, userRowMapper);	
		return contacts;
	}
	
	private class UserRowMapper implements ParameterizedRowMapper<Contact> {
		
		@Override
		public Contact mapRow(ResultSet rs, int row) throws SQLException {
			Contact user = new Contact();
			user.setId(rs.getLong("idcontact"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			return user;
		}
		
	}
	
}
