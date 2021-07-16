package com.ismt.model;

public class OrderedProduct {
	int id ;
	int order_id;
	int product_id;
	int quantity;

	public int getOrder_id() {
		return order_id;
	}

	public OrderedProduct setOrder_id(int order_id) {
		this.order_id = order_id;
		return this;
	}

	public int getProduct_id() {
		return product_id;
	}

	public OrderedProduct setProduct_id(int product_id) {
		this.product_id = product_id;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderedProduct setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public int getId() {
		return id;
	}

	public OrderedProduct setId(int id) {
		this.id = id;
		return this;
	}
}
