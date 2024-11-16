package com.project.sapbackend.controller;


import com.project.sapbackend.entity.AcceptedMeasure;
import com.project.sapbackend.entity.CableBrand;
import com.project.sapbackend.service.AcceptedMeasureService;
import com.project.sapbackend.service.CableBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/accepted-measure")
public class AcceptedMeasureController {
    private final AcceptedMeasureService acceptedMeasureService;


    @GetMapping("/")
    public List<AcceptedMeasure> getCableBrands() {
        return acceptedMeasureService.findAll();
    }
}
