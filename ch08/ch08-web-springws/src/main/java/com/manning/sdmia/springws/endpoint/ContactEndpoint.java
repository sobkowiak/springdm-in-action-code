package com.manning.sdmia.springws.endpoint;

//import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.jdom.Element;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

import com.manning.sdmia.directory.model.Contact;
import com.manning.sdmia.directory.service.ContactService;

//@Endpoint
public class ContactEndpoint extends AbstractJDomPayloadEndpoint {
	private ContactService contactService;

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	protected Element invokeInternal(Element element) throws Exception {
		Element root = new Element("GetContactsResponse");
		for (Contact contact : contactService.getContacts()) {
			Element contactElement = new Element("Contacts");
			root.addContent(contactElement);
			Element idElement = new Element("Id");
			idElement.setText(String.valueOf(contact.getId()));
			contactElement.addContent(idElement);
			Element firstnameElement = new Element("FirstName");
			firstnameElement.setText(contact.getFirstname());
			contactElement.addContent(firstnameElement);
			Element lastnameElement = new Element("LastName");
			lastnameElement.setText(contact.getLastname());
			contactElement.addContent(lastnameElement);
		}
		return root;
	}

}
