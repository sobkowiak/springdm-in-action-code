/**
 * 
 */
package com.manning.sdmia.enterprise.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.manning.sdmia.enterprise.dao.UserDao;
import com.manning.sdmia.enterprise.domain.User;

/**
 * @author acogoluegnes
 *
 */
public class UserDaoJdbc extends SimpleJdbcDaoSupport implements UserDao {
	
	private static final String SQL_SELECT_USERS = "select iduser,firstname,lastname from enterprise_user";
	
	private UserRowMapper userRowMapper = new UserRowMapper();

	/* (non-Javadoc)
	 * @see com.manning.sdmia.enterprise.dao.UserDao#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		List<User> users = getSimpleJdbcTemplate().query(SQL_SELECT_USERS, userRowMapper);	
		return users;
	}
	
	private class UserRowMapper implements ParameterizedRowMapper<User> {
		
		@Override
		public User mapRow(ResultSet rs, int row) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("iduser"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			return user;
		}
		
	}
	
	@Override
	public void dummyOnceAgain() {
		System.out.println("DUMMY ONCE AGAIN");		
	}

}
