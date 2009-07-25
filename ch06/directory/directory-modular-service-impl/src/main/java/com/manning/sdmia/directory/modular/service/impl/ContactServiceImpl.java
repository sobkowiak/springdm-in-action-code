/**
 * 
 */
package com.manning.sdmia.directory.modular.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.manning.sdmia.directory.dao.ContactDao;
import com.manning.sdmia.directory.domain.Contact;
import com.manning.sdmia.directory.service.ContactService;

/**
 * @author acogoluegnes
 *
 */
@Transactional
public class ContactServiceImpl implements ContactService {
	
	private ContactDao contactDao;
	
	/*
	 * (non-Javadoc)
	 * @see com.manning.sdmia.directory.service.ContactService#getContacts()
	 */
	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = contactDao.getContacts();
		return contacts;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
