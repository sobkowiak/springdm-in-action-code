/**
 * 
 */
package com.manning.sdmia.directory.service;

import java.util.List;

import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public interface ContactService {

	/**
	 * 
	 * @return
	 */
	public List<Contact> getContacts();
	
}
