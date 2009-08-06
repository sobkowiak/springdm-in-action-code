package com.manning.sdmia.dataaccess.service.impl;

import java.util.List;

import com.manning.sdmia.dataaccess.domain.dao.ContactsDao;
import com.manning.sdmia.dataaccess.domain.model.Contact;
import com.manning.sdmia.dataaccess.service.ContactsService;

public class ContactsServiceImpl implements ContactsService {
	private ContactsDao contactsDao;

	public void addContact(Contact contact) {
		contactsDao.addContact(contact);
	}

	public void deleteContact(Contact contact) {
		contactsDao.deleteContact(contact);
	}

	public List<Contact> getContacts() {
		return contactsDao.getContacts();
	}

	public Contact getContact(long id) {
		return contactsDao.getContact(id);
	}

	public void updateContact(Contact contact) {
		contactsDao.updateContact(contact);
	}

	public ContactsDao getContactsDao() {
		return contactsDao;
	}

	public void setContactsDao(ContactsDao contactsDao) {
		this.contactsDao = contactsDao;
	}

}
