package com.example.demo.mapping.job.impl;

import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.Job;
import com.example.demo.mapping.job.JobMapping;

import org.springframework.stereotype.Component;

@Component
public class JobMappingImpl implements JobMapping {

    @Override
    public Job mapJobDtoToJob(JobDTO jobDTO) {
        Job job=new Job();
        job.setName(jobDTO.getName());
        job.setSalary(jobDTO.getSalary());
        job.setDescription(jobDTO.getDescription());
        job.setDue(jobDTO.getDue());
        return job;
    }

    @Override
    public JobDTO mapJobtoJobDTO(Job job) {
        JobDTO jobDTO=new JobDTO();
        jobDTO.setName(job.getName());
        jobDTO.setSalary(job.getSalary());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setDue(job.getDue());
        return jobDTO;
       
    }
    
}
