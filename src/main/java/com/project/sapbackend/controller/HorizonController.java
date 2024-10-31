package com.project.sapbackend.controller;


import com.project.sapbackend.entity.Horizon;
import com.project.sapbackend.entity.ProductionObject;
import com.project.sapbackend.service.HorizonService;
import com.project.sapbackend.service.ProductionObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/horizon")
public class HorizonController {
    private final HorizonService horizonService;


    @GetMapping("/")
    public List<Horizon> getHorizon() {
        return horizonService.findAll();
    }
}
