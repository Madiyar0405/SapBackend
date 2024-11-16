package com.project.sapbackend.controller;


import com.project.sapbackend.entity.CableBrand;
import com.project.sapbackend.entity.IncidentStatus;
import com.project.sapbackend.service.CableBrandService;
import com.project.sapbackend.service.IncidentStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/incident-status")
public class IncidentStatusController {
    private final IncidentStatusService incidentStatusService;


    @GetMapping("/")
    public List<IncidentStatus> getCableBrands() {
        return incidentStatusService.findAll();
    }
}
