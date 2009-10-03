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
	
}
