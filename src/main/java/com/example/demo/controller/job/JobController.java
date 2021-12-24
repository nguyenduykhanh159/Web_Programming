package com.example.demo.controller.job;


import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.job.JobDTO;
import com.example.demo.service.job.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {


    @Autowired
    private JobService jobService;


    @GetMapping
    public BaseResponse getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public BaseResponse getJob(@PathVariable("id") Integer jobId) {
        return jobService.getJob(jobId);
    }

    @PostMapping
    public BaseResponse addJob(@RequestBody JobDTO job) {
        
        return jobService.addJob(job);
    }

    @DeleteMapping("/{id}")
    public BaseResponse removeJob(@PathVariable("id") Integer jobId)
    {
        return jobService.removeJob(jobId);
    }
}
