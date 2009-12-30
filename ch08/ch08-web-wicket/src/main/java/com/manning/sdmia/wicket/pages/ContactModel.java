package com.manning.sdmia.wicket.pages;

import org.apache.wicket.model.LoadableDetachableModel;

import com.manning.sdmia.directory.model.Contact;

public class ContactModel extends LoadableDetachableModel {
	private Contact contact;

	public ContactModel(Contact contact) {
		super(contact);
		this.contact = contact;
	}
	
	protected Object load()	{
		return contact;
	}

}
