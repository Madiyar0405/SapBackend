package com.project.sapbackend.controller;


import com.project.sapbackend.entity.LayingMethod;
import com.project.sapbackend.service.LayingMethodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/laying-method")
public class LayingMethodController {
    private final LayingMethodService layingMethodService;


    @GetMapping("/")
    public List<LayingMethod> getAllLayingMethods() {
        return layingMethodService.findAll();
    }

}
