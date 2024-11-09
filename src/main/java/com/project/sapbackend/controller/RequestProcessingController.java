package com.project.sapbackend.controller;


import com.project.sapbackend.entity.RequestProcessing;
import com.project.sapbackend.service.RequestProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request-processing")
@RequiredArgsConstructor
public class RequestProcessingController {
    private final RequestProcessingService requestProcessingService;
    @PostMapping
    public ResponseEntity<?> createRequestProcessing(
            @RequestBody RequestProcessing requestProcessing,
            @RequestParam Long incidentRequestId
    ) {
        return ResponseEntity.ok(requestProcessingService.createRequestProcessing(requestProcessing, incidentRequestId));

    }
}
