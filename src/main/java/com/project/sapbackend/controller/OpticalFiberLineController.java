package com.project.sapbackend.controller;


import com.project.sapbackend.entity.OpticalFiberLine;
import com.project.sapbackend.service.OpticalFiberLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/optical-fiber-line")
public class OpticalFiberLineController {
    private final OpticalFiberLineService opticalFiberLineService;

    @GetMapping("/")
    public List<OpticalFiberLine> getOpticalFiberLines() {
        return opticalFiberLineService.findAll();
    }

}
