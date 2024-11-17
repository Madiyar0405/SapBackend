package com.project.sapbackend.controller;


import com.project.sapbackend.entity.RequestExtensionCause;
import com.project.sapbackend.service.RequestExtensionCausesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/request-extension-causes")
@RequiredArgsConstructor
public class RequestExtensionCausesController {

    private final RequestExtensionCausesService requestExtensionCausesService;

    @GetMapping("/")
    public ResponseEntity<List<RequestExtensionCause>> getAllRequestExtensionCauses() {

        return ResponseEntity.ok(requestExtensionCausesService.findAll());
    }

}
