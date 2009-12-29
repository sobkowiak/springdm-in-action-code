package com.manning.sdmia.web.springmvc.controller;

import java.util.List;

import org.springframework.osgi.extensions.annotation.ServiceReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manning.sdmia.directory.model.Contact;
import com.manning.sdmia.directory.service.ContactService;

@Controller
public class ContactsController {
	private ContactService contactService;
	
	public ContactService getContactService() {
		return contactService;
	}

	@ServiceReference
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping("/contacts.do")
	public ModelMap getContacts() {
		List<Contact> contacts = contactService.getContacts();
		return new ModelMap("contacts", contacts);
	}
}
