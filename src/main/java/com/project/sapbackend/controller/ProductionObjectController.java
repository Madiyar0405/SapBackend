package com.project.sapbackend.controller;


import com.project.sapbackend.entity.ProductionObject;
import com.project.sapbackend.service.ProductionObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/production-object")
public class ProductionObjectController {
    private final ProductionObjectService productionObjectService;

    @GetMapping("/")
    public List<ProductionObject> getProductionObjects() {
        return productionObjectService.findAll();
    }
}
