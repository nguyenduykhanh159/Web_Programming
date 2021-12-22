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
        job.setId(jobDTO.getId());
        job.setImage_url(jobDTO.getImage_url());
        job.setAddress(jobDTO.getAddress());
        job.setCreate_At(jobDTO.getCreate_At());
        job.setContact(jobDTO.getContact());
        job.setContact_number(jobDTO.getContact_number());
        job.setJob_detail(jobDTO.getJob_detail());
        job.setSalary(jobDTO.getSalary());
        job.setDescription(jobDTO.getDescription());
        job.setDue(jobDTO.getDue());
        return job;
    }

    @Override
    public JobDTO mapJobtoJobDTO(Job job) {
        JobDTO jobDTO=new JobDTO();
        jobDTO.setName(job.getName());
        jobDTO.setId(job.getId());
        jobDTO.setImage_url(job.getImage_url());
        jobDTO.setAddress(job.getAddress());
        jobDTO.setCreate_At(job.getCreate_At());
        jobDTO.setContact(job.getContact());
        jobDTO.setContact_number(job.getContact_number());
        jobDTO.setJob_detail(job.getJob_detail());
        jobDTO.setSalary(job.getSalary());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setDue(job.getDue());
        return jobDTO;
       
    }
    
}
