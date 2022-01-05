package com.example.demo.controller.job;



import com.example.demo.base.response.BaseResponse;
import com.example.demo.dto.job.FarmerJobDTO;
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

    @GetMapping("/detail/{id}")
    public BaseResponse getJob(@PathVariable("id") Integer jobId) {
        return jobService.getJob(jobId);
    }

    @GetMapping("/createdJob")
    public BaseResponse createdJob()
    {
        return jobService.getCreatedJobs();
    }

    @GetMapping("/createdJob/{id}")
    public BaseResponse createdJobDetail(@PathVariable("id") Integer jobId)
    {
        return jobService.getCreatedJobDetail(jobId);
    }
    
    @GetMapping("/receivedJob")
    public BaseResponse receivedJob()
    {
        return jobService.getReceivedJobs();
    }

    @PostMapping
    public BaseResponse addJob(@RequestBody JobDTO job) {
        
        return jobService.createJob(job);
    }

    @DeleteMapping("/{id}")
    public BaseResponse removeJob(@PathVariable("id") Integer jobId)
    {
        return jobService.removeJob(jobId);
    }

    @GetMapping("/completeJob/{id}")
    public BaseResponse completedJob(@PathVariable("id") Integer jobId)
    {
        return jobService.completedJob(jobId);
    }
    @PostMapping("/rejectJob/{id}")
    public BaseResponse rejectJob(@RequestBody FarmerJobDTO farmerJobDTO, @PathVariable("id") Integer jobId)
    {
        return jobService.rejectJob(farmerJobDTO,jobId);
    }
    @PostMapping("/assignJob/{id}")
    public BaseResponse assignJob(@RequestBody FarmerJobDTO farmerJobDTO,@PathVariable("id") Integer jobId)
    {
        return jobService.assignJob(farmerJobDTO,jobId);
    }

    @PostMapping("/receiveJob/{id}")
    public BaseResponse receiveJob(@RequestBody FarmerJobDTO farmerJobDTO,@PathVariable("id") Integer jobId)
    {
        return jobService.receiveJob(farmerJobDTO,jobId);
    }
    
}
