/**
 * 
 */
package com.manning.sdmia.directory.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manning.sdmia.directory.dao.ContactDao;
import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ContactDaoJdbcTest {
	
	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void setUp() throws Exception {
		DatabaseOperation.CLEAN_INSERT.execute(
				new DatabaseDataSourceConnection(dataSource),
				new FlatXmlDataSet(getClass().getResourceAsStream("/com/manning/sdmia/directory/dao/jdbc/contacts-dataset.xml"))
		);
	}

	@Test public void getContacts() {
		List<Contact> contacts = contactDao.getContacts();
		Assert.assertEquals(3,contacts.size());
	}
	
	@Test public void getContactsIsInFirstnameOrLastname() {
		List<Contact> contacts = contactDao.getContacts("an");
		Assert.assertEquals(1,contacts.size());
		contacts = contactDao.getContacts("a");
		Assert.assertEquals(2,contacts.size());
		contacts = contactDao.getContacts("an");
		Assert.assertEquals(1,contacts.size());
		contacts = contactDao.getContacts("t");
	}
	
	@Test public void create() {
		int countContacts = contactDao.getContacts().size();
		Contact contact = new Contact(null,"Cynthia","Kane");
		contactDao.create(contact);
		Assert.assertNotNull(contact.getId());
		Assert.assertEquals(countContacts+1,contactDao.getContacts().size());
	}
	
}
