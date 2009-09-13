/**
 * 
 */
package com.manning.sdmia.directory.dao.jdbc;

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
	
	private static final String SQL_SELECT_CONTACTS_IN_FIRST_LAST_NAME = "select idcontact,firstname,lastname from directory_contact " +
			"where upper(firstname) like ? or upper(lastname) like ?";
	
	private static final String SQL_SELECT_NEXT_CONTACT_ID = "select next value for seq_directory_contact_idcontact";
	
	private static final String SQL_INSERT_CONTACT = "insert into directory_contact (idcontact,firstname,lastname) " +
			"values (?,?,?);";
	
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
	
	/*
	 * (non-Javadoc)
	 * @see com.manning.sdmia.directory.dao.ContactDao#getContacts(java.lang.String)
	 */
	@Override
	public List<Contact> getContacts(String isInFirstnameOrLastname) {
		List<Contact> contacts = getSimpleJdbcTemplate().query(
			SQL_SELECT_CONTACTS_IN_FIRST_LAST_NAME, userRowMapper,
			"%"+isInFirstnameOrLastname.toUpperCase()+"%","%"+isInFirstnameOrLastname.toUpperCase()+"%"
		);	
		return contacts;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.manning.sdmia.directory.dao.ContactDao#create(com.manning.sdmia.directory.domain.Contact)
	 */
	@Override
	public Contact create(Contact contact) {
		long id = getJdbcTemplate().queryForLong(SQL_SELECT_NEXT_CONTACT_ID);		
		getSimpleJdbcTemplate().update(SQL_INSERT_CONTACT,id,contact.getFirstname(),contact.getLastname());
		contact.setId(id);
		return contact;
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
