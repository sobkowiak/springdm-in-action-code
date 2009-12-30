package com.manning.sdmia.springws.bean;

import java.util.HashSet;
import java.util.Set;

import com.manning.sdmia.directory.model.Contact;

public class GetContactsResponse {
	private Set<Contact> contacts = new HashSet<Contact>();

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}
