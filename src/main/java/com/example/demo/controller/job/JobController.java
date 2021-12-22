package com.example.demo.controller.job;

import java.util.List;

import com.example.demo.dto.job.JobDTO;
import com.example.demo.service.job.JobService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobDTO getJob(@PathVariable("id") Integer jobId) {
        return jobService.getJob(jobId);
    }

    @PostMapping
    public boolean addJob(@RequestBody JobDTO job) {
        jobService.addJob(job);
        return true;
    }
}
