package com.project.sapbackend.controller;


import com.project.sapbackend.dto.RequestProcessingDTO;
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
//            @RequestBody RequestProcessing requestProcessing,
//            @RequestParam Long incidentRequestId

            @RequestBody RequestProcessingDTO request
    ) {
        return ResponseEntity.ok(requestProcessingService.createRequestProcessing(request));

    }


    @GetMapping("/")
    public ResponseEntity<List<RequestProcessing>> getAllRequestProcessing() {
        return ResponseEntity.ok(requestProcessingService.findAll());
    }
}
