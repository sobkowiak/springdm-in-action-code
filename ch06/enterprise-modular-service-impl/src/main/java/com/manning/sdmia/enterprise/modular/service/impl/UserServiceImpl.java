/**
 * 
 */
package com.manning.sdmia.enterprise.modular.service.impl;

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
		System.out.println("----------- GET USERS -----------");
		List<User> users = userDao.getUsers();
//		userDao.dummyOnceAgain();
//		users.add(new User(-1L,"Spring","OSGi"));
		return users; 
	}
	
	@Override
	public void alert() {
		System.out.println("----------- ALERT -----------");		
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
