package com.example.demo.service.job.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.dao.JobRepository;
import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.Job;
import com.example.demo.mapping.job.JobMapping;
import com.example.demo.service.job.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapping jobMapping;

    @Override
    public BaseResponse getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return new BaseResponse<JobDTO>(HttpStatus.OK, "All jobs",
                jobs.stream().map(job -> jobMapping.mapJobtoJobDTO(job)).collect(Collectors.toList()));
    }

    @Override
    public BaseResponse getJob(int jobId) {
        try {
            Job job = jobRepository.getById(jobId);
            JobDTO jobDTO = jobMapping.mapJobtoJobDTO(job);
            return new BaseResponse<JobDTO>(HttpStatus.OK, "All jobs", jobDTO);
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @Override
    public BaseResponse addJob(JobDTO jobDTO) {
        try {
            Job job = jobMapping.mapJobDtoToJob(jobDTO);
            jobRepository.save(job);
            return new BaseResponse<JobDTO>(HttpStatus.OK, "Add successfully!", jobMapping.mapJobtoJobDTO(job));
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.BAD_REQUEST, "Add failed! "+e.getMessage());
        }

        
    }

    @Override
    public BaseResponse removeJob(int jobId) {
        try {
            jobRepository.deleteById(jobId);
            return new BaseResponse<JobDTO>(HttpStatus.OK, "Remove successfully!");
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.BAD_REQUEST, "Remove failed! "+e.getMessage());
        }
        
    }

}
