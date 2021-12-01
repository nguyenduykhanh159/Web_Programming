package com.example.demo.model;

public class JobModel {
    private int jobID;
    private String name;
    private String description;
    private float fee;

    public JobModel() {

    }

    public JobModel(int jobID, String name, String description, float fee) {
        this.jobID = jobID;
        this.name = name;
        this.description = description;
        this.fee = fee;
    }

    public int getJobID() {
        return this.jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getFee() {
        return this.fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

}
