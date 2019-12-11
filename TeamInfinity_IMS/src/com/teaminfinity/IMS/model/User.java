package com.teaminfinity.IMS.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public User() {}
	
	// contact user
	private String fName;
	private String lName;
	private String email;
	// business info
	private String bName;
	private String streetAdd;
	private String streetAdd2;
	private String city;
	private String province;
	private String postal;
	private String country;
	
	public User(String p1, String p2, String p3, String p4, String p5, String 
				p6, String p7, String p8, String p9, String p10) {
		this.fName = p1;
		this.lName = p2;
		this.email = p3;
		this.bName = p4;
		this.streetAdd = p5;
		this.streetAdd2 = p6;
		this.city = p7;
		this.province = p8;
		this.postal = p9;
		this.country = p10;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
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

}
