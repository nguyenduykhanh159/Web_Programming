package com.example.demo.model;

import java.util.List;

public class OrderModel {
    private int orderID;
    private List<ProductModel> listProduct;
    private String createAt;
    private String receiveAt;

    public OrderModel() {

    }

    public OrderModel(int orderID, List<ProductModel> listProduct, String createAt, String receiveAt) {
        this.orderID = orderID;
        this.listProduct = listProduct;
        this.createAt = createAt;
        this.receiveAt = receiveAt;
    }

    public int getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public List<ProductModel> getListProduct() {
        return this.listProduct;
    }

    public void setListProduct(List<ProductModel> listProduct) {
        this.listProduct = listProduct;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getReceiveAt() {
        return this.receiveAt;
    }

    public void setReceiveAt(String receiveAt) {
        this.receiveAt = receiveAt;
    }

}
