package com.manning.sdmia.web.jsf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.manning.sdmia.directory.model.Contact;

public class ContactConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String s) {
		Long id = Long.parseLong(s);
		Contact contact = new Contact();
		contact.setId(id);
		return contact;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object o) {
		return String.valueOf(((Contact)o).getId());
	}

}
