package com.ismt.model;

public class CartItem {
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private double itemTotal;


    public CartItem(String productName, String description, double price, int quantity, double itemTotal) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    public String getProductName() {
        return productName;
    }

    public CartItem setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CartItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CartItem setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public CartItem setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
        return this;
    }




}
