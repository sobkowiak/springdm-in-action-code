/**
 * 
 */
package com.manning.sdmia.directory.soa.dao;

import java.util.List;

import com.manning.sdmia.directory.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public interface ContactDao {

	/**
	 * get {@link Contact}s.
	 * @return
	 */
	public List<Contact> getContacts();
	
}
