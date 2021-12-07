package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.JobModel;
import com.example.demo.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/job")
public class JobController {
    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobModel> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobModel getJob(@PathVariable("id") int jobId) {
        return jobService.getJob(jobId);
    }

    @PostMapping
    public int addJob(@RequestBody JobModel job) {
        jobService.addJob(job);
        return 1;
    }
}
