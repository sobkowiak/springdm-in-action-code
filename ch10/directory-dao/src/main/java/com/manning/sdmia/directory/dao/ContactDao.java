/**
 * 
 */
package com.manning.sdmia.directory.dao;

import java.util.List;

import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public interface ContactDao {

	/**
	 * Get {@link Contact}s.
	 * @return
	 */
	public List<Contact> getContacts();
	
	/**
	 * Get {@link Contact} that have the string in the firstname or the lastname.
	 * @param isInFirstnameOrLastname
	 * @return
	 */
	public List<Contact> getContacts(String isInFirstnameOrLastname);
	
	/**
	 * Create a contact.
	 * @param contact
	 * @return
	 */
	public Contact create(Contact contact);
	
}
