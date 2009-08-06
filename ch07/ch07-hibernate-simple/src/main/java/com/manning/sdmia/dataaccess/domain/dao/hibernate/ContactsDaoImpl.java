package com.manning.sdmia.dataaccess.domain.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.manning.sdmia.dataaccess.domain.dao.ContactsDao;
import com.manning.sdmia.dataaccess.domain.model.Contact;

public class ContactsDaoImpl extends HibernateDaoSupport implements ContactsDao {

	public List<Contact> getContacts() {
		return getHibernateTemplate().find("select c from Contact c order by c.id");
	}

	public void addContact(Contact contact) {
		getHibernateTemplate().persist(contact);
	}

	public void deleteContact(Contact contact) {
		getHibernateTemplate().delete(contact);
	}

	public void updateContact(Contact contact) {
		getHibernateTemplate().merge(contact);
	}

	public Contact getContact(long id) {
		return (Contact) getHibernateTemplate().load(Contact.class, id);
	}
}
