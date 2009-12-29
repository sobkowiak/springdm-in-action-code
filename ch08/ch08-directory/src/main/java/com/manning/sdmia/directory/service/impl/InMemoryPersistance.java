package com.manning.sdmia.directory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.manning.sdmia.directory.model.Contact;

public abstract class InMemoryPersistance {
	private static Map<Long,Contact> contacts;
	
	static {
		Contact contact1 = new Contact();
		contact1.setId(1l);
		contact1.setFirstname("Arnaud");
		contact1.setLastname("Cogoluegnes");

		Contact contact2 = new Contact();
		contact2.setId(2l);
		contact2.setFirstname("Andy");
		contact2.setLastname("Piper");

		Contact contact3 = new Contact();
		contact3.setId(3l);
		contact3.setFirstname("Thierry");
		contact3.setLastname("Templier");

		contacts = new HashMap<Long,Contact>();
		contacts.put(contact1.getId(), contact1);
		contacts.put(contact2.getId(), contact2); 
		contacts.put(contact3.getId(), contact3);		
	}

	public static void addContact(Contact contact) {
		contacts.put(contact.getId(), contact);
	}

	public static Contact loadContact(long id) {
		return (Contact) contacts.get(id);
	}
	
	public static void deleteContact(Contact product) {
		contacts.remove(product.getId());
	}

	public static void updateContact(Contact product) {
		contacts.put(product.getId(), product);
	}

	public static List<Contact> getContacts() {
		return new ArrayList(contacts.values());
	}
}
