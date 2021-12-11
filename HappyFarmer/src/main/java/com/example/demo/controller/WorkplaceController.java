package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.WorkplaceModel;
import com.example.demo.service.WorkplaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/workplace")
public class WorkplaceController {
    private WorkplaceService workplaceService;

    @Autowired
    public WorkplaceController(WorkplaceService workplaceService) {
        this.workplaceService = workplaceService;
    }

    @GetMapping
    public List<WorkplaceModel> getAllWorkplaces() {
        return workplaceService.getAllWorkplaces();
    }

    @GetMapping("/{id}")
    public WorkplaceModel getWorkplace(@PathVariable("id") int workplaceId) {
        return workplaceService.getWorkplace(workplaceId);
    }

    @PostMapping
    public int addWorkplace(@RequestBody WorkplaceModel workplace) {
        workplaceService.addWorkplace(workplace);
        return 1;
    }
}
