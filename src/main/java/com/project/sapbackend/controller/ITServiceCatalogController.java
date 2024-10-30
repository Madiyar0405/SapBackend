package com.project.sapbackend.controller;


import com.project.sapbackend.entity.ITServiceCatalog;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.repository.ITServiceCatalogRepo;
import com.project.sapbackend.service.ITServiceCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/it-service-catalogue")
public class ITServiceCatalogController {
    private final ITServiceCatalogService itServiceCatalogService;

    @GetMapping("/")
    public List<ITServiceCatalog> getAllItServiceCatalog() {
        return itServiceCatalogService.findAll();
    }

}
