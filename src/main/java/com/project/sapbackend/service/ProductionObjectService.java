package com.project.sapbackend.service;


import com.project.sapbackend.entity.Location;
import com.project.sapbackend.entity.ProductionObject;
import com.project.sapbackend.repository.LocationRepo;
import com.project.sapbackend.repository.ProductionObjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionObjectService {
    private final ProductionObjectRepo productionObjectRepo;

    public List<ProductionObject> findAll() {
        return productionObjectRepo.findAll();
    }
}
