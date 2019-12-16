package com.teaminfinity.IMS.model;

import java.io.Serializable;

public class Persons implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int personId;
	private String firstName;
	private String lastName;
	private String email;
	private boolean users;
	
	public Persons() {}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUsers() {
		return users;
	}

	public void setUsers(boolean users) {
		this.users = users;
	}

}
