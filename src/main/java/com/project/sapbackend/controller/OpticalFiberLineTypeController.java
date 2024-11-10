package com.project.sapbackend.controller;


import com.project.sapbackend.entity.OpticalFiberLineType;
import com.project.sapbackend.service.OpticalFiberLineTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/optical-fiber-line-type")
public class OpticalFiberLineTypeController {
    private final OpticalFiberLineTypeService opticalFiberLineTypeService;

    @GetMapping("/")
    public List<OpticalFiberLineType> getOpticalFiberLineTypes() {
        return opticalFiberLineTypeService.findAll();
    }
}
