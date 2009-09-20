/**
 * 
 */
package com.manning.sdmia.ch10.domain;

/**
 * @author acogoluegnes
 *
 */
public class Contact {

	private String login,password;

	public Contact(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public boolean isPasswordCorrect(String passwordToCheck) {
		return password.equals(passwordToCheck);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
