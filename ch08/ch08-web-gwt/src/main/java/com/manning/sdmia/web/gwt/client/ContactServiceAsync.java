package com.manning.sdmia.web.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.manning.sdmia.directory.model.Contact;

public interface ContactServiceAsync {
	void getContacts(AsyncCallback<List<Contact>> callback);
}
