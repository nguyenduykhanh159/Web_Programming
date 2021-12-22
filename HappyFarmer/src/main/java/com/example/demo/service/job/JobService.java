package com.example.demo.service.job;

import java.util.List;

import com.example.demo.dto.job.JobDTO;

public interface JobService {
    List<JobDTO> getAllJobs();
    JobDTO getJob(int jobId);
    boolean addJob(JobDTO jobDTO);
    boolean removeJob(int jobId);


}
