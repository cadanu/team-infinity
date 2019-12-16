package com.teaminfinity.IMS.model;

public class Hasher {
	// ACME password hasher XD
	private String plainText;
	
	public Hasher(String plainText) {
		this.plainText = plainText;
		getHashed(this.plainText);
	}
	
	public static String getHashed(String plainText) {
		return "hashed";
	}

}
