package com.manning.sdmia.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.manning.sdmia.directory.model.Contact;
import com.manning.sdmia.directory.service.ContactService;

public class ContactsPage extends WebPage {
	@SpringBean(name="contactService")
	private ContactService contactService;

	public ContactsPage() {
        add(new Label("message", "Contact list"));

        IModel produitsModel = new LoadableDetachableModel() {
			protected Object load() {
				System.out.println("contactService = "+contactService);
				return getContactService().getContacts();
			}
		};
		
		ContactsListView dataView = new ContactsListView("datas", produitsModel) {
            protected void populateItem(final ListItem item, Contact contact) {
                //Product product = (Product)item.getModelObject();
                // item.add(new ActionPanel("actions", item.getModel()));
                //cf ajout de <td><span wicket:id="actions">[actions]</span></td> dans html
                item.add(new Label("id", String.valueOf(contact.getId())));
                item.add(new Label("firstname", contact.getFirstname()));
                item.add(new Label("lastname", contact.getLastname()));
            }
		};
        add(dataView);
	}
	
	public ContactService getContactService() {
        //return ((DirectoryApplication)getApplication()).getContactService();
		return contactService;
	}
}
