package com.project.sapbackend.service;


import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.LayingMethod;
import com.project.sapbackend.entity.Location;
import com.project.sapbackend.repository.IncidentRequestRepo;
import com.project.sapbackend.repository.LayingMethodRepo;
import com.project.sapbackend.repository.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LayingMethodService {
    private LayingMethodRepo layingMethodRepo;


    public List<LayingMethod> findAll() {
        return layingMethodRepo.findAll();
    }
}
