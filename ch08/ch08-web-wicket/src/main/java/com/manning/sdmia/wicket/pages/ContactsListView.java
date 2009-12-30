package com.manning.sdmia.wicket.pages;

import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;

import com.manning.sdmia.directory.model.Contact;

public abstract class ContactsListView extends ListView {

	public ContactsListView(String id, IModel model) {
		super(id, model);
	}

	protected IModel getListItemModel(IModel listViewModel, int index) {
		List list = (List) listViewModel.getObject();
		Contact contact = (Contact) list.get(index);
		return new ContactModel(contact);
	}

	protected ListItem newItem(int index) {
		return new OddEvenListItem(index, getListItemModel(getModel(), index));
	}

	protected void populateItem(ListItem item) {
		Contact contact = (Contact) item.getModelObject();
		populateItem(item, contact);
	}

	protected abstract void populateItem(ListItem item, Contact contact);

}
