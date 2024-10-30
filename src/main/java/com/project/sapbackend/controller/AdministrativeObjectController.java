package com.project.sapbackend.controller;


import com.project.sapbackend.entity.AdministrativeObject;
import com.project.sapbackend.service.AdministrativeObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/administrative-object")
public class AdministrativeObjectController {
    private final AdministrativeObjectService administrativeObjectService;

    @GetMapping("/")
    public List<AdministrativeObject> getAdministrativeObjects() {
        return administrativeObjectService.findAll();
    }

}
