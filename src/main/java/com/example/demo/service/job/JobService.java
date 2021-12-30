package com.example.demo.service.job;


import java.util.List;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.job.FarmerJobDTO;
import com.example.demo.dto.job.JobDTO;

public interface JobService {
    BaseResponse getAllJobs();
    BaseResponse getCreatedJobs();
    BaseResponse getCreatedJobDetail(int jobId);
    BaseResponse getReceivedJobs();
    BaseResponse getJob(int jobId);
    BaseResponse createJob(JobDTO jobDTO);
    BaseResponse removeJob(int jobId);
    BaseResponse assignJob(FarmerJobDTO farmerJobDTO,int jobId);
    BaseResponse receiveJob(FarmerJobDTO farmerJobDTO,int jobId);
    BaseResponse completedJob(int jobId);
    BaseResponse rejectJob(FarmerJobDTO farmerJobDTO,int jobId);

    



}
