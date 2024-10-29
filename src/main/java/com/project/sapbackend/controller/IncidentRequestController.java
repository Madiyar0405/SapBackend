package com.project.sapbackend.controller;

import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.service.IncidentRequestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incident-requests")
public class IncidentRequestController {
    private IncidentRequestService incidentRequestService;

    @PostMapping
    public IncidentRequest registerIncidentRequest(@RequestBody IncidentRequest incidentRequest) {
        return incidentRequestService.save(incidentRequest);
    }
}
