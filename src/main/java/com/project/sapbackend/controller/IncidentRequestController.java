package com.project.sapbackend.controller;

import com.project.sapbackend.dto.IncidentRequestDTO;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.RequestProcessing;
import com.project.sapbackend.service.IncidentRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incident-requests")
@RequiredArgsConstructor
public class IncidentRequestController {
    private final IncidentRequestService incidentRequestService;

    @PostMapping
    public IncidentRequest registerIncidentRequest(@RequestBody IncidentRequest incidentRequest) {
        return incidentRequestService.save(incidentRequest);
    }
    @GetMapping
    public List<IncidentRequest> getAllIncidentRequests() {
        return incidentRequestService.findAll();
    }

    @GetMapping("/with-status")
    public List<IncidentRequestDTO> getIncidentRequestsWithStatus() {
        return incidentRequestService.findAllWithStatus();
    }
}
