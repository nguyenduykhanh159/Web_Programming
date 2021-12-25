package com.example.demo.service.job.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.base.response.BaseResponse;
import com.example.demo.base.response.NotFoundResponse;
import com.example.demo.dao.FarmerJobRepository;
import com.example.demo.dao.JobRepository;
import com.example.demo.dto.job.FarmerJobDTO;
import com.example.demo.dto.job.JobDTO;
import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.Workplace;
import com.example.demo.entity.job.Job;
import com.example.demo.entity.job.JobStatus;
import com.example.demo.entity.user.FarmerJob;
import com.example.demo.entity.user.FarmerJobID;
import com.example.demo.entity.user.FarmerJobStatus;
import com.example.demo.mapping.job.JobMapping;
import com.example.demo.service.job.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private FarmerJobRepository fJobRepository;

    @Autowired
    private JobMapping jobMapping;


    @Override
    public BaseResponse getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return new BaseResponse<JobDTO>(HttpStatus.OK, "All jobs",
                jobs.stream().map(job -> jobMapping.mapJobtoJobDTO(job)).collect(Collectors.toList()));
    }

    @Override
    public BaseResponse getJob(int jobId) {
        try {
            Job job = jobRepository.getById(jobId);
            JobDTO jobDTO = jobMapping.mapJobtoJobDTO(job);
            return new BaseResponse<JobDTO>(HttpStatus.OK, "All jobs", jobDTO);
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @Override
    public BaseResponse addJob(JobDTO jobDTO) {
        try {
            CustomUserDetails user=(CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            
            Job job = jobMapping.mapJobDtoToJob(jobDTO);
            Workplace workplace = new Workplace();
            workplace.setAddress(jobDTO.getAddress());
            workplace.setArea(jobDTO.getArea());
            job.setCreateAt(new Date());
            job.setWorkplace(workplace);
            job.setOwner(user.getUser());
            jobRepository.save(job);
            return new BaseResponse<JobDTO>(HttpStatus.OK, "Add successfully!", jobMapping.mapJobtoJobDTO(job));
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.BAD_REQUEST, "Add failed! " + e.getMessage());
        }

    }

    @Override
    public BaseResponse removeJob(int jobId) {
        try {
            jobRepository.deleteById(jobId);
            return new BaseResponse<JobDTO>(HttpStatus.OK, "Remove successfully!");
        } catch (Exception e) {
            return new NotFoundResponse(HttpStatus.BAD_REQUEST, "Remove failed! " + e.getMessage());
        }

    }

    @Override
    public BaseResponse assignJob(FarmerJobDTO farmerJobDTO, int jobId) {

        try {
            FarmerJobID fjId = new FarmerJobID(jobId, farmerJobDTO.getWorkerId());
            Optional<FarmerJob> farmerJobOpt = fJobRepository.findById(fjId);
            FarmerJob farmerJob = farmerJobOpt.get();
            farmerJob.getJob().setJobStatus(JobStatus.PENDING);
            farmerJob.setAcceptedAt(new Date());
            farmerJob.setStatus(FarmerJobStatus.ACCEPTED);

            fJobRepository.save(farmerJob);

            farmerJobDTO.setAcceptedAt(farmerJob.getAcceptedAt());
            farmerJobDTO.setStatus(farmerJob.getStatus().toString());

            return new BaseResponse<>(HttpStatus.OK, "Assign job successful!", farmerJobDTO);
        } catch (Exception ex) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Assign failed! " + ex.getMessage());
        }

    }

    @Override
    public BaseResponse receiveJob(FarmerJobDTO farmerJobDTO, int jobId) {

        try {
            FarmerJobID fjId = new FarmerJobID(jobId, farmerJobDTO.getWorkerId());
            FarmerJob farmerJob = new FarmerJob();
            farmerJob.setFarmerJobID(fjId);
            farmerJob.setReceivedAt(new Date());
            farmerJob.setComment(farmerJobDTO.getComment());
            farmerJob.setDealPrice(farmerJobDTO.getDealPrice());
            farmerJob.setStatus(FarmerJobStatus.REQUESTING);
            fJobRepository.save(farmerJob);

            farmerJobDTO.setJobId(jobId);
            farmerJobDTO.setReceivedAt(farmerJob.getReceivedAt());
            farmerJobDTO.setStatus(farmerJob.getStatus().toString());

            return new BaseResponse<>(HttpStatus.OK, "Receive job successful!", farmerJobDTO);
        } catch (Exception ex) {
            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Receive failed! " + ex.getMessage());

        }

    }

    @Override
    public BaseResponse completedJob(int jobId) {

        try {
            Job job = jobRepository.getById(jobId);

            job.setJobStatus(JobStatus.COMPLETED);

            jobRepository.save(job);

            JobDTO jobDTO = jobMapping.mapJobtoJobDTO(job);
            return new BaseResponse<>(HttpStatus.OK, "Job completed!", jobDTO);
        } catch (Exception e) {

            return new BaseResponse<>(HttpStatus.BAD_REQUEST, "Complete job failed! " + e.getMessage());
        }
    }

    @Override
    public BaseResponse rejectJob(FarmerJobDTO farmerJobDTO, int jobId) {

        try {
            FarmerJobID fjId = new FarmerJobID(jobId, farmerJobDTO.getWorkerId());
            Optional<FarmerJob> farmerJobOpt = fJobRepository.findById(fjId);

            FarmerJob farmerJob = farmerJobOpt.get();
            farmerJob.setStatus(FarmerJobStatus.REJECTED);

            fJobRepository.save(farmerJob);

            farmerJobDTO.setStatus(farmerJob.getStatus().toString());

            return new BaseResponse<>(HttpStatus.OK, "Reject successfull", farmerJobDTO);

        } catch (Exception e) {
            return new BaseResponse<>(HttpStatus.BAD_GATEWAY, "Reject failed! " + e.getMessage());
        }

    }
}
