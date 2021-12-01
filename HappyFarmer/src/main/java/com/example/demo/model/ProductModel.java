package com.example.demo.model;

public class ProductModel {
    private int productID;
    private String name;
    private String madeIn;
    private float price;
    private int quantity;
    private String expirationDay;

    public ProductModel() {

    }

    public ProductModel(int productID, String name, String madeIn, float price, int quantity, String expirationDay) {
        this.productID = productID;
        this.name = name;
        this.madeIn = madeIn;
        this.price = price;
        this.quantity = quantity;
        this.expirationDay = expirationDay;
    }

    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMadeIn() {
        return this.madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpirationDay() {
        return this.expirationDay;
    }

    public void setExpirationDay(String expirationDay) {
        this.expirationDay = expirationDay;
    }

}