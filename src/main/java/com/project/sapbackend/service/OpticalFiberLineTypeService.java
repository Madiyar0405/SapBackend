package com.project.sapbackend.service;


import com.project.sapbackend.entity.Location;
import com.project.sapbackend.entity.OpticalFiberLineType;
import com.project.sapbackend.repository.LocationRepo;
import com.project.sapbackend.repository.OpticalFiberLineTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpticalFiberLineTypeService {
    private final OpticalFiberLineTypeRepo opticalFiberLineTypeRepo;

    public List<OpticalFiberLineType> findAll() {
        return opticalFiberLineTypeRepo.findAll();
    }
}
