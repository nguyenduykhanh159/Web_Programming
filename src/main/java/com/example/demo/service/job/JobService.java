package com.example.demo.service.job;


import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.job.JobDTO;

public interface JobService {
    BaseResponse getAllJobs();
    BaseResponse getJob(int jobId);
    BaseResponse addJob(JobDTO jobDTO);
    BaseResponse removeJob(int jobId);


}
