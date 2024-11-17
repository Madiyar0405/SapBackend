package com.project.sapbackend.controller;

import com.project.sapbackend.dto.IncidentRequestDTO;
import com.project.sapbackend.entity.IncidentRequest;
//import com.project.sapbackend.entity.IncidentRequestCause;
import com.project.sapbackend.entity.RequestProcessing;
import com.project.sapbackend.service.IncidentRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/incident-requests")
@RequiredArgsConstructor
public class IncidentRequestController {
    private final IncidentRequestService incidentRequestService;

    @PostMapping
    @Transactional
    public IncidentRequest registerIncidentRequest(@RequestBody IncidentRequest incidentRequest) {

//        Set<IncidentRequestCause> incidentRequestCauses = incidentRequest.getIncidentRequestCauses();
//        incidentRequest.setIncidentRequestCauses(null);
//        IncidentRequest incidentRequestSaved = incidentRequestService.save(incidentRequest);
//        if (incidentRequest.getIncidentRequestCauses() == null) {
//            System.out.println("Works");
//            incidentRequestCauses.forEach(cause -> cause.setIncidentRequest(incidentRequestSaved));
//        }
//        incidentRequestSaved.setIncidentRequestCauses(incidentRequestCauses);
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
