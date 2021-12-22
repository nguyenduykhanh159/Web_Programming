package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.WorkplaceDTO;
import com.example.demo.service.workplace.WorkplaceService;

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

    @Autowired
    private WorkplaceService workplaceService;

    @GetMapping
    public List<WorkplaceDTO> getAllWorkplaces() {
        return workplaceService.getAllWorkplaces();
    }

    @GetMapping("/{id}")
    public WorkplaceDTO getWorkplace(@PathVariable("id") int workplaceId) {
        return workplaceService.getWorkplace(workplaceId);
    }

    @PostMapping
    public int addWorkplace(@RequestBody WorkplaceDTO workplace) {
        workplaceService.addWorkplace(workplace);
        return 1;
    }
}
