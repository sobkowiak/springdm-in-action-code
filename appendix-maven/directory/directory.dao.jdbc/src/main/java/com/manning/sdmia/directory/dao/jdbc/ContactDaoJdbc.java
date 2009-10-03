/**
 * 
 */
package com.manning.sdmia.directory.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.manning.sdmia.directory.dao.ContactDao;
import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 * 
 */
public class ContactDaoJdbc extends JdbcDaoSupport implements ContactDao {

	private static final String SQL_SELECT_CONTACTS = "select idcontact,firstname,lastname from directory_contact";
	
	private UserRowMapper userRowMapper = new UserRowMapper();

	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = getJdbcTemplate().query(SQL_SELECT_CONTACTS, userRowMapper);	
		return contacts;
	}

	private class UserRowMapper implements RowMapper<Contact> {

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
