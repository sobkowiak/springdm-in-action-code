package com.manning.sdmia.dataaccess.domain.dao;

import java.util.List;

import com.manning.sdmia.dataaccess.domain.model.Contact;

public interface ContactsDao {
	List<Contact> getContacts();
	void addContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContact(Contact contact);
	Contact getContact(long id);
}
