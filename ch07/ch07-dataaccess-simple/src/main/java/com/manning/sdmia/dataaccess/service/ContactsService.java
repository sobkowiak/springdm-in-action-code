package com.manning.sdmia.dataaccess.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.manning.sdmia.dataaccess.domain.model.Contact;

@Transactional
public interface ContactsService {
	@Transactional(readOnly=true)
	List<Contact> getContacts();
	void addContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContact(Contact contact);
	@Transactional(readOnly=true)
	Contact getContact(long id);
}
