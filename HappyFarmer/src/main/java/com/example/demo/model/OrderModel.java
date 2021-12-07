package com.example.demo.model;

import java.util.List;

public class OrderModel {
    private int orderID;
    private List<ProductDetail> listProduct;
    private String createAt;
    private String receiveAt;

    public OrderModel() {

    }

    public OrderModel(int orderID, List<ProductDetail> listProduct, String createAt, String receiveAt) {
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

    public List<ProductDetail> getListProduct() {
        return this.listProduct;
    }

    public void setListProduct(List<ProductDetail> listProduct) {
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
