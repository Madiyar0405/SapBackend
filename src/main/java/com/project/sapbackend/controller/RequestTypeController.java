package com.project.sapbackend.controller;


import com.project.sapbackend.entity.ITServiceCatalog;
import com.project.sapbackend.entity.RequestType;
import com.project.sapbackend.service.RequestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/request-types")
public class RequestTypeController {
    private final RequestTypeService requestTypeService;

    @GetMapping("/")
    public List<RequestType> getAllItServiceCatalog() {
        return requestTypeService.findAll();
    }
}
