package com.example.demo.model;

public class WorkplaceModel {
    private int placeID;
    private String typeOfWork;
    private float area;
    private String address;

    public WorkplaceModel() {

    }

    public WorkplaceModel(int placeID, String typeOfWork, float area, String address) {
        this.placeID = placeID;
        this.typeOfWork = typeOfWork;
        this.area = area;
        this.address = address;
    }

    public int getPlaceID() {
        return this.placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getTypeOfWork() {
        return this.typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public float getArea() {
        return this.area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
