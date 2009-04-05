/**
 * 
 */
package com.manning.sdmia.enterprise.domain;

/**
 * @author acogoluegnes
 *
 */
public class User {

	private Long id;
	
	private String firstname,lastname;

	public User(Long id, String firstname, String lastname) {
		this();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
