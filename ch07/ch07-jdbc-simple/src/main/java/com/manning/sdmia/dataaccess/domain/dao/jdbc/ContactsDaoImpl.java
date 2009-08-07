package com.manning.sdmia.dataaccess.domain.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.manning.sdmia.dataaccess.domain.dao.ContactsDao;
import com.manning.sdmia.dataaccess.domain.model.Address;
import com.manning.sdmia.dataaccess.domain.model.Contact;

public class ContactsDaoImpl extends JdbcDaoSupport implements ContactsDao {

	public List<Contact> getContacts() {
		String sql = "select c.id as contact_id, c.last_name, c.first_name, a.id as address_id, a.city" +
						" from contact as c left outer join address as a on (c.id=a.contact_id)" +
						" order by c.id asc";
		return (List<Contact>) getJdbcTemplate().query(sql, new ResultSetExtractor() {
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
				int currentContactId = -1;
				Contact currentContact = null;
				List<Contact> contacts = new ArrayList<Contact>(); 
				while (rs.next()) {
					int contactId = rs.getInt("contact_id");
					if (currentContactId!=contactId) {
						Contact contact = new Contact();
						contact.setId(contactId);
						contact.setFirstName(rs.getString("first_name"));
						contact.setLastName(rs.getString("last_name"));
						contact.setAddresses(new ArrayList<Address>());
						contacts.add(contact);
						currentContact = contact;
						currentContactId = contact.getId();
					}

					int addressId = rs.getInt("address_id");
					if (addressId>0) {
						Address address = new Address();
						address.setId(addressId);
						address.setCity(rs.getString("city"));
						currentContact.getAddresses().add(address);
					}
				}
				return contacts;
			}
		});
	}

	public Contact getContact(long id) {
		String sql = "select id, last_name, first_name from contact where id=?";
		Contact contact = (Contact) getJdbcTemplate().queryForObject(
					sql, new Object[] { id }, new ContactRowMapper());

		sql = "select id, city from contact where contact_id=?";
		List<Address> addresses = (List<Address>) getJdbcTemplate().query(
					sql, new Object[] { id }, new AddressRowMapper(contact));

		return contact;
	}

	public void addContact(Contact contact) {
		String sql = "insert into contact (id,last_name,first_name) values(?,?,?)";
		getJdbcTemplate().update(sql, new Object[] { contact.getId(),
							contact.getLastName(), contact.getFirstName() });
	}

	public void deleteContact(Contact contact) {
		String sql = "delete from contact where id=?";
		getJdbcTemplate().update(sql, new Object[] { contact.getId() });
	}

	public void updateContact(Contact contact) {
		String sql = "update contact set last_name=?, first_name=? where id=?";
		getJdbcTemplate().update(sql, new Object[] { contact.getLastName(),
							contact.getFirstName(), contact.getId() });
	}

}
