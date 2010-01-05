package com.manning.sdmia.web.gwt.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.manning.sdmia.directory.model.Contact;

public class DirectoryApplication implements EntryPoint {
	private DockPanel mainPanel = new DockPanel();
	private FlexTable table = new FlexTable();

	private ContactServiceAsync contactService = null;

	public void onModuleLoad() {
		contactService = (ContactServiceAsync) GWT
								.create(ContactService.class);

		ServiceDefTarget endpoint = (ServiceDefTarget) contactService;
		endpoint.setServiceEntryPoint("../services/contactService.rpc");

		RootPanel.get("main").add(mainPanel);
		Panel contactsPanel = new VerticalPanel();
		mainPanel.add(contactsPanel, DockPanel.CENTER);

		contactsPanel.add(table);
		
		getContacts();
	}

	private void getContacts() {
		contactService.getContacts(new AsyncCallback<List<Contact>>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.toString());
			}

			public void onSuccess(List<Contact> contacts) {
				fillTable(contacts);
			}
		});
		
	}

	private void fillTable(List<Contact> contacts) {
		table.clear();
		int index = 0;
		Window.alert("contacts : "+contacts.size());
		for (Contact contact : contacts) {
			Window.alert("contact : "+contact.getFirstname());
		    table.setWidget(index, 0, new Label(String.valueOf(contact.getId())));
			table.setWidget(index, 1, new Label(contact.getFirstname()));
			table.setWidget(index, 2, new Label(contact.getLastname()));
			index++;
		}
	}
}
