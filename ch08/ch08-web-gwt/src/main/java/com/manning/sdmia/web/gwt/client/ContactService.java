package com.manning.sdmia.web.gwt.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.manning.sdmia.directory.model.Contact;

public interface ContactService extends RemoteService {
	List<Contact> getContacts();
}
