package com.project.sapbackend.service;


import com.project.sapbackend.entity.CableBrand;
import com.project.sapbackend.entity.Horizon;
import com.project.sapbackend.repository.CableBrandRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CableBrandService {
    private CableBrandRepo cableBrandRepo;

    public List<CableBrand> findAll() {
        return cableBrandRepo.findAll();
    }
}
