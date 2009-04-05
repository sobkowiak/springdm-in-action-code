/**
 * 
 */
package com.manning.sdmia.enterprise.dao;

import java.util.List;

import com.manning.sdmia.enterprise.domain.User;

/**
 * @author acogoluegnes
 *
 */
public interface UserDao {

	/**
	 * get {@link User}.
	 * @return
	 */
	public List<User> getUsers();
	
}
