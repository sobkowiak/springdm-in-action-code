package com.manning.sdmia.web.restlet.resource;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import org.jdom.DocType;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.restlet.data.MediaType;
import org.restlet.engine.Engine;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.manning.sdmia.directory.model.Contact;
import com.manning.sdmia.directory.service.ContactService;

public class ContactsResource extends ServerResource {
	private ContactService contactService;
	
	private String createRepresentationString(List<Contact> contacts) {
		Element root = new Element("Contacts");
		Document document = new Document(root);
		for (Contact contact : contacts) {
			Element contactElement = new Element("Contact");
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
		
		StringWriter writer = new StringWriter();
		XMLOutputter outputter = new XMLOutputter();
	    try {
	      outputter.output(document, writer);       
	    } catch(IOException ex) {
	      ex.printStackTrace();
	    }
	    
	    return writer.toString();
	}
	
	@Get
	public Representation representContacts(Variant variant) {
		Engine.getInstance().registerDefaultConverters();
		List<Contact> contacts = contactService.getContacts();
		return new StringRepresentation(
			createRepresentationString(contacts), MediaType.TEXT_PLAIN);
			//createRepresentationString(contacts), MediaType.APPLICATION_XML);
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

}
