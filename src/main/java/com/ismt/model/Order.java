package com.ismt.model;

public class Order {
	int id;
	String orderNumber;
	double total;
	String customerName;
	String billingAddress;
	String phoneNumber;


	public Order() {
	}

	public Order(int id, String orderNumber, double total, String customerName, String billingAddress, String phoneNumber) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.total = total;
		this.customerName = customerName;
		this.billingAddress = billingAddress;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
