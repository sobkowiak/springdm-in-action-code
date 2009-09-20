/**
 * 
 */
package com.manning.sdmia.ch10.service.impl;

import com.manning.sdmia.ch10.dao.ContactDao;
import com.manning.sdmia.ch10.domain.Contact;
import com.manning.sdmia.ch10.exception.BusinessException;
import com.manning.sdmia.ch10.service.ContactService;

/**
 * @author acogoluegnes
 *
 */
public class ContactServiceImpl implements ContactService {
	
	private ContactDao contactDao;

	/* (non-Javadoc)
	 * @see com.manning.sdmia.ch10.service.ContactService#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public Contact authenticate(String login, String password)
			throws BusinessException {
		Contact contact = contactDao.getByLogin(login);
		if(isInRepositoryAndPasswordCorrect(contact, password)) {
			return contact;
		} else {
			throw new BusinessException("Authentication is incorrect");
		}
	}
	
	private boolean isInRepositoryAndPasswordCorrect(Contact contact,String pwd) {
		return contact != null && contact.isPasswordCorrect(pwd);
	}
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

}
