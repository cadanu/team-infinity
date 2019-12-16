package com.teaminfinity.IMS.model;

import java.io.Serializable;
import java.sql.Date;

public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int po_id;
	private Date date;
	private int userId;
	private int productId;
	private int customerId;
	
	public PurchaseOrder() {}

	public int getPo_id() {
		return po_id;
	}

	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
