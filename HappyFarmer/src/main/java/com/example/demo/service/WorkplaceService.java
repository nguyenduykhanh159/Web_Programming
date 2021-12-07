package com.example.demo.service;

import java.util.List;

import com.example.demo.model.WorkplaceModel;

public interface WorkplaceService {
    public List<WorkplaceModel> getAllWorkplaces();
    public WorkplaceModel getWorkplace(int workplaceId);
    public void addWorkplace(WorkplaceModel workplace);
}
