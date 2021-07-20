package com.ismt.model;

public class CartItem {
    private int productId;
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private double itemTotal;



    public CartItem(String productName, String description, double price, int quantity, double itemTotal,int productId) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
        this.productId=productId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
