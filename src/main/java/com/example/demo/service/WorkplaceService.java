package com.example.demo.service;

import com.example.demo.dto.WorkplaceDTO;

import java.util.List;


public interface WorkplaceService {
    public List<WorkplaceDTO> getAllWorkplaces();
    public WorkplaceDTO getWorkplace(int workplaceId);
    public void addWorkplace(WorkplaceDTO workplace);
}
