package com.manning.sdmia.wicket;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.manning.sdmia.wicket.pages.ContactsPage;

public class DirectoryApplication extends WebApplication {
	//private ContactService contactService;

	public void init() {
        super.init();
        
    	addComponentInstantiationListener(new SpringComponentInjector(this));
    }

	public Class getHomePage() {
        return ContactsPage.class;
	}

	/*public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}*/

}
