package com.example.demo.mapping;

import com.example.demo.dto.JobDTO;
import com.example.demo.entity.Job;

public interface JobMapping {
    Job mapJobDtoToJob(JobDTO jobDTO);
}
