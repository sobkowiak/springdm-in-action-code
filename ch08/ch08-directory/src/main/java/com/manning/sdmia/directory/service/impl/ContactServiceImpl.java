package com.manning.sdmia.directory.service.impl;

import java.util.List;

import com.manning.sdmia.directory.model.Contact;
import com.manning.sdmia.directory.service.ContactService;

public class ContactServiceImpl implements ContactService {

	public List<Contact> getContacts() {
		//System.out.println("> ContactServiceImpl.getContacts()");
		return InMemoryPersistance.getContacts();
	}

}
