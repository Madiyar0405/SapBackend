package com.project.sapbackend.service;


import com.project.sapbackend.entity.AcceptedMeasure;
import com.project.sapbackend.entity.AdministrativeObject;
import com.project.sapbackend.repository.AcceptedMeasureRepo;
import com.project.sapbackend.repository.AdministrativeObjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcceptedMeasureService {
    private final AcceptedMeasureRepo acceptedMeasureRepo;

    public List<AcceptedMeasure> findAll() {
        return acceptedMeasureRepo.findAll();
    }
}
