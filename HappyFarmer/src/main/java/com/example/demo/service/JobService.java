package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.JobDTO;

public interface JobService {
    public List<JobDTO> getAllJobs();
    public JobDTO getJob(int id);
    public void addJob(JobDTO job);
}
