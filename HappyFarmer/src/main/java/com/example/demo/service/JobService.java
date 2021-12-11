package com.example.demo.service;

import java.util.List;

import com.example.demo.model.JobModel;

public interface JobService {
    public List<JobModel> getAllJobs();
    public JobModel getJob(int id);
    public void addJob(JobModel job);
}
