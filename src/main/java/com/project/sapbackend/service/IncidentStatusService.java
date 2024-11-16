package com.project.sapbackend.service;


import com.project.sapbackend.entity.IncidentStatus;
import com.project.sapbackend.entity.LayingMethod;
import com.project.sapbackend.repository.IncidentStatusRepo;
import com.project.sapbackend.repository.LayingMethodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentStatusService {
    private final IncidentStatusRepo incidentStatusRepo;


    public List<IncidentStatus> findAll() {
        return incidentStatusRepo.findAll();
    }
}
