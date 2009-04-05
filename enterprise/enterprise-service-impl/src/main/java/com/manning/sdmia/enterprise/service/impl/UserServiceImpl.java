/**
 * 
 */
package com.manning.sdmia.enterprise.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.manning.sdmia.enterprise.dao.UserDao;
import com.manning.sdmia.enterprise.domain.User;
import com.manning.sdmia.enterprise.service.UserService;

/**
 * @author acogoluegnes
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.manning.sdmia.enterprise.service.UserService#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
