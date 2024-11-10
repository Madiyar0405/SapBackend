package com.project.sapbackend.service;


import com.project.sapbackend.entity.OpticalFiberLine;
import com.project.sapbackend.repository.OpticalFiberLineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpticalFiberLineService {
    private final OpticalFiberLineRepo opticalFiberLineRepo;

    public List<OpticalFiberLine> findAll() {
        return opticalFiberLineRepo.findAll();
    }
}
