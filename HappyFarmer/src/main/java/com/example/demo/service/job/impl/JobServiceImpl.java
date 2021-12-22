package com.example.demo.service.job.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dao.JobRepository;
import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.Job;
import com.example.demo.mapping.job.JobMapping;
import com.example.demo.service.job.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobMapping jobMapping;

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(job -> jobMapping.mapJobtoJobDTO(job)).collect(Collectors.toList());
    }

    @Override
    public JobDTO getJob(int jobId) {
        Job job = jobRepository.getById(jobId);
        return jobMapping.mapJobtoJobDTO(job);
    }

    @Override
    public boolean addJob(JobDTO jobDTO) {
        try {
            Job job = jobMapping.mapJobDtoToJob(jobDTO);
            jobRepository.save(job);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeJob(int jobId) {
        try {
            jobRepository.deleteById(jobId);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

}
