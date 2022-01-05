package com.example.demo.mapping.job.impl;

import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.job.Job;
import com.example.demo.entity.job.JobStatus;
import com.example.demo.mapping.job.JobMapping;

import org.springframework.stereotype.Component;

@Component
public class JobMappingImpl implements JobMapping {

    @Override
    public Job mapJobDtoToJob(JobDTO jobDTO) {
        Job job=new Job();
        job.setName(jobDTO.getName());
        job.setImageUrl(jobDTO.getImageUrl());
        job.setAddress(jobDTO.getAddress());
        job.setSalary(jobDTO.getSalary());
        job.setDescription(jobDTO.getDescription());
        job.setDue(jobDTO.getDue());
        job.setJobStatus(JobStatus.FINDING);
        return job;
    }

    @Override
    public JobDTO mapJobtoJobDTO(Job job) {
        
        JobDTO jobDTO=new JobDTO();
        jobDTO.setName(job.getName());
        jobDTO.setId(job.getId());
        jobDTO.setImageUrl(job.getImageUrl());
        jobDTO.setAddress(job.getAddress());
        jobDTO.setCreatedAt(job.getCreatedAt());
        jobDTO.setContact(job.getContact());
        jobDTO.setContactNumber(job.getContactNumber());
        jobDTO.setSalary(job.getSalary());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setDue(job.getDue());
        jobDTO.setJobStatus(job.getJobStatus().toString());
        return jobDTO;
       
    }
    
}
