package com.manning.sdmia.dataaccess.domain.dao.hibernatejpa;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.manning.sdmia.dataaccess.domain.dao.ContactsDao;
import com.manning.sdmia.dataaccess.domain.model.Contact;

public class ContactsDaoImpl extends JpaDaoSupport implements ContactsDao {

	public List<Contact> getContacts() {
		return getJpaTemplate().find("select c from Contact c order by c.id");
	}

	public void addContact(Contact contact) {
		getJpaTemplate().persist(contact);
	}

	public void deleteContact(Contact contact) {
		getJpaTemplate().remove(contact);
	}

	public void updateContact(Contact contact) {
		getJpaTemplate().merge(contact);
	}

	public Contact getContact(long id) {
		return getJpaTemplate().getReference(Contact.class, id);
	}
}
