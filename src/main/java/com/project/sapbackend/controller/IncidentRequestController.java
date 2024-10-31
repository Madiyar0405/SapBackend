package com.project.sapbackend.controller;

import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.service.IncidentRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/incident-requests")
@RequiredArgsConstructor
public class IncidentRequestController {
    private final IncidentRequestService incidentRequestService;

    @PostMapping
    public IncidentRequest registerIncidentRequest(@RequestBody IncidentRequest incidentRequest) {
        return incidentRequestService.save(incidentRequest);
    }
}
