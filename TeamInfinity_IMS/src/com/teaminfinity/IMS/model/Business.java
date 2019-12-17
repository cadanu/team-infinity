package com.teaminfinity.IMS.model;

import java.io.Serializable;

public class Business implements Serializable {
	private static final long serialVersionUID = 1L;

	private String businessName;
	private String streetAdd;
	private String streetAdd2;
	private String city;
	private String province;
	private String postal;
	private String country;
	private int entityId;
	
	public Business() {}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getStreetAdd() {
		return streetAdd;
	}

	public void setStreetAdd(String streetAdd) {
		this.streetAdd = streetAdd;
	}

	public String getStreetAdd2() {
		return streetAdd2;
	}

	public void setStreetAdd2(String streetAdd2) {
		this.streetAdd2 = streetAdd2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

}
