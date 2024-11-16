package com.project.sapbackend.controller;


import com.project.sapbackend.entity.CableBrand;
import com.project.sapbackend.service.CableBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cable-brand")
public class CableBrandController {
    private final CableBrandService cableBrandService;


    @GetMapping("/")
    public List<CableBrand> getCableBrands() {
        return cableBrandService.findAll();
    }
}
