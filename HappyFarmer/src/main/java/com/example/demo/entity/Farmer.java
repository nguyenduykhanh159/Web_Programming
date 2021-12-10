package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="farmer")
public class Farmer extends User {
    @Column(name="age")
    private int age;


    //1 farmer can have n workplaces
    @OneToMany(mappedBy = "farmer")
    private Set<Workplace> workplaces=new HashSet<Workplace>();
    //1 farmer create n jobs
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<Job> createdJob =new HashSet<Job>();
    

    //1 farmer do n jobs
    @OneToMany(mappedBy = "worker")
    @JsonIgnore
    private Set<FarmerJob> doJob=new HashSet<FarmerJob>();

    @OneToMany(mappedBy = "farmer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<FarmerSociety> societies=new HashSet<>();


    public Set<FarmerSociety> getSocieties() {
        return societies;
    }

    public void setSocieties(Set<FarmerSociety> societies) {
        this.societies = societies;
    }



    public Set<Job> getCreatedJob() {
        return this.createdJob;
    }

    public void setCreatedJob(Set<Job> createdJob) {
        this.createdJob = createdJob;
    }

    public Set<FarmerJob> getDoJob() {
        return this.doJob;
    }

    public void setDoJob(Set<FarmerJob> doJob) {
        this.doJob = doJob;
    }


    public void setWorkplaces(Set<Workplace> workplaces) {
        this.workplaces = workplaces;
    }
    public Set<Workplace> getWorkplaces() {
        return this.workplaces;
    }
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
