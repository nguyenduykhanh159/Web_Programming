package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.JobRepository;
import com.example.demo.dto.JobDTO;
import com.example.demo.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{
    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public JobDTO getJob(int jobId) {
        return jobRepository.findById(jobId);
    }

    @Override
    public void addJob(JobDTO job) {
        jobRepository.addJob(job);
    }
}
