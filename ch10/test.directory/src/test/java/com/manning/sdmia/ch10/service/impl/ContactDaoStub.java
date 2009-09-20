/**
 * 
 */
package com.manning.sdmia.ch10.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.manning.sdmia.ch10.dao.ContactDao;
import com.manning.sdmia.ch10.domain.Contact;

/**
 * @author acogoluegnes
 *
 */
public class ContactDaoStub implements ContactDao {
	
	private Map<String, Contact> directory = new HashMap<String, Contact>(){{
		put("acogoluegnes",new Contact("acogoluegnes", "pwd4arno"));
	}};

	/* (non-Javadoc)
	 * @see com.manning.sdmia.ch10.dao.ContactDao#getByLogin(java.lang.String)
	 */
	@Override
	public Contact getByLogin(String login) {		
		return directory.get(login);
	}

}
