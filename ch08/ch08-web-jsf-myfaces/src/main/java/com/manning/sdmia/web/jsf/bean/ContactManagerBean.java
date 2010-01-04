package com.manning.sdmia.web.jsf.bean;

import java.util.List;

import com.manning.sdmia.directory.model.Contact;
import com.manning.sdmia.directory.service.ContactService;

public class ContactManagerBean {
	private ContactService contactService;

	public ContactManagerBean() {
		System.out.println("new ContacsBean - "+this);
	}
	
	public List<Contact> getContacts() {
		return contactService.getContacts();
	}
	
	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
}
