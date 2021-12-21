package com.example.demo.mapping;

import com.example.demo.dto.WorkplaceDTO;
import com.example.demo.entity.Workplace;

public interface WorkplaceMapping {
    Workplace mapWorkplaceDtoToWorkplace(WorkplaceDTO workplaceDTO);
}
