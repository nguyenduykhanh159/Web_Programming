package com.example.demo.service;

import com.example.demo.model.WorkplaceModel;

import java.util.List;


public interface WorkplaceService {
    public List<WorkplaceModel> getAllWorkplaces();
    public WorkplaceModel getWorkplace(int workplaceId);
    public void addWorkplace(WorkplaceModel workplace);
}
