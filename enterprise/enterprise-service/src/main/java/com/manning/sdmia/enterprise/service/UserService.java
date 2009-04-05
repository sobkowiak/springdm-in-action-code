/**
 * 
 */
package com.manning.sdmia.enterprise.service;

import java.util.List;

import com.manning.sdmia.enterprise.domain.User;

/**
 * @author acogoluegnes
 *
 */
public interface UserService {

	/**
	 * 
	 * @return
	 */
	public List<User> getUsers();
	
}
