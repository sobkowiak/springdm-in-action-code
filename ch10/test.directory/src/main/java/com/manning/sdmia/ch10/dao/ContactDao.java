/**
 * 
 */
package com.manning.sdmia.ch10.dao;

import com.manning.sdmia.ch10.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public interface ContactDao {

	/**
	 * 
	 * @param login
	 * @return
	 */
	public Contact getByLogin(String login);
	
}
