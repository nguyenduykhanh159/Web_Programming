package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.MockDataRepo;
import com.example.demo.model.WorkplaceModel;
import com.example.demo.service.WorkplaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkplaceServiceImpl implements WorkplaceService{
    private final MockDataRepo dataRepo;

    @Autowired
    public WorkplaceServiceImpl(MockDataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @Override
    public List<WorkplaceModel> getAllWorkplaces() {
        return dataRepo.getAllWorkplaces();
    }

    @Override
    public WorkplaceModel getWorkplace(int workplaceId) {
        return dataRepo.getWorkplace(workplaceId);
    }

    @Override
    public void addWorkplace(WorkplaceModel workplace) {
        dataRepo.addWorkplace(workplace);
    }
}
