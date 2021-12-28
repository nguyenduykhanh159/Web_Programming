package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.workplace.WorkplaceDTO;


public interface WorkplaceService {
    public List<WorkplaceDTO> getAllWorkplaces();
    public WorkplaceDTO getWorkplace(int workplaceId);
    public void addWorkplace(WorkplaceDTO workplace);
}
