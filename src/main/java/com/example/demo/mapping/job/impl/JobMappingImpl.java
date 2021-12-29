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
        job.setId(jobDTO.getId());
        job.setImageUrl(jobDTO.getImageUrl());
        job.setAddress(jobDTO.getAddress());
        job.setCreatedAt(jobDTO.getCreatedAt());
        job.setContact(jobDTO.getContact());
        job.setContactNumber(jobDTO.getContactNumber());
        job.setJobDetail(jobDTO.getJobDetail());
        job.setSalary(jobDTO.getSalary());
        job.setDescription(jobDTO.getDescription());
        job.setDue(jobDTO.getDue());
        job.setJobStatus(JobStatus.FINDING);
        return job;
    }

    @Override
    public JobDTO mapJobtoJobDTO(Job job) {
        JobDTO jobDTO=JobDTO.builder()
       .name(job.getName())
       .id(job.getId())
       .imageUrl(job.getImageUrl())
       .address(job.getAddress())
       .createdAt(job.getCreatedAt())
       .contact(job.getContact())
       .contactNumber(job.getContactNumber())
       .jobDetail(job.getJobDetail())
       .salary(job.getSalary())
       .description(job.getDescription())
       .due(job.getDue())
       .area(job.getWorkplace().getArea())
       .jobStatus(job.getJobStatus().toString())
       .build();
        return jobDTO;
       
    }
    
}
