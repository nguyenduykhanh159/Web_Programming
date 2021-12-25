package com.example.demo.mapping.job;

import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.job.Job;

public interface JobMapping {
    Job mapJobDtoToJob(JobDTO jobDTO);
    JobDTO mapJobtoJobDTO(Job job);
}
