/**
 * 
 */
package com.manning.sdmia.ch10.service;

import com.manning.sdmia.ch10.domain.Contact;
import com.manning.sdmia.ch10.exception.BusinessException;

/**
 * @author acogoluegnes
 *
 */
public interface ContactService {

	/**
	 * Authenticate a {@link Contact} with login/password.
	 * @param login
	 * @param password
	 * @return
	 * @throws BusinessException
	 */
	Contact authenticate(String login,String password) throws BusinessException;
	
}
