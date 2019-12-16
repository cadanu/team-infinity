package com.teaminfinity.IMS.model;

import java.io.Serializable;

public class Authorized implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String password;
	private int entityId;
	
	public Authorized() {}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Hasher.getHashed(password);
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	
	

}
