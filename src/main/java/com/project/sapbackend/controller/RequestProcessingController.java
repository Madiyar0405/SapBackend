package com.project.sapbackend.controller;


import com.project.sapbackend.dto.RequestProcessingDTO;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.RequestProcessing;
import com.project.sapbackend.service.RequestProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request-processing")
@RequiredArgsConstructor
public class RequestProcessingController {
    private final RequestProcessingService requestProcessingService;
    @PostMapping
    public ResponseEntity<?> createRequestProcessing(

            @RequestBody RequestProcessingDTO requestProcessingDTO
//            @RequestBody IncidentRequest incidentRequestId
//            @RequestParam(required = false) Long incidentRequestId
    ) {
        System.out.println(requestProcessingDTO.getRequestProcessing());
        System.out.println(requestProcessingDTO.getIncidentRequest());
        return ResponseEntity.ok(requestProcessingService.createRequestProcessing(requestProcessingDTO));
    }

    @GetMapping
    public List<RequestProcessing> getAllRequestProcessing() {
        return requestProcessingService.findAll();
    }
}

