package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.model.JobModel;
import com.example.demo.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
    private final MockDataRepo dataRepo;

    @Autowired
    public JobServiceImpl(MockDataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @Override
    public List<JobModel> getAllJobs() {
        return dataRepo.getAllJobs();
    }

    @Override
    public JobModel getJob(int jobId) {
        return dataRepo.getJob(jobId);
    }

    @Override
    public void addJob(JobModel job) {
        dataRepo.addJob(job);
    }
}
