/**
 * 
 */
package com.manning.sdmia.enterprise.dao.simple;

import java.util.ArrayList;
import java.util.List;

import com.manning.sdmia.enterprise.dao.UserDao;
import com.manning.sdmia.enterprise.domain.User;

/**
 * @author acogoluegnes
 *
 */
public class UserDaoSimple implements UserDao {

	/* (non-Javadoc)
	 * @see com.manning.sdmia.enterprise.dao.UserDao#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		List<User> res = new ArrayList<User>();
		res.add(new User(1L,"Arnaud","Cogoluegnes"));
		res.add(new User(2L,"Andy","Piper"));
		res.add(new User(3L,"Thierry","Templier"));
		return res;
	}

}
