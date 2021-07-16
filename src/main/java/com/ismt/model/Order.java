package com.ismt.model;

public class Order {
	int id;
	String order_number;
	double total;
	int customer_id;
	String customerName;
	String billingAddress;
	String phoneNumber;


	public Order(int id, String order_number, double total) {
		this.id = id;
		this.order_number = order_number;
		this.total = total;
	}

	public Order() {
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Order(int id, String order_number, double total, int customer_id) {
		this.id = id;
		this.order_number = order_number;
		this.total = total;
		this.customer_id = customer_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
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

	public Order setCustomerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public Order setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Order setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
}
