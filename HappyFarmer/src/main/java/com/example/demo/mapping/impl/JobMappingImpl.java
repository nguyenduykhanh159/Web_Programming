package com.example.demo.mapping.impl;

import com.example.demo.dto.JobDTO;
import com.example.demo.entity.Job;
import com.example.demo.mapping.JobMapping;

import org.springframework.stereotype.Component;

@Component
public class JobMappingImpl implements JobMapping {
    @Override
    public Job mapJobDtoToJob(JobDTO jobDTO) {
        Job job = new Job();
        job.setDescription(jobDTO.getDescription());
        job.setName(jobDTO.getName());
        job.setFee(jobDTO.getFee());
        job.setDue(jobDTO.getDue());
        return job;
    }
}
