package com.project.sapbackend.service;


import com.project.sapbackend.entity.AdministrativeObject;
import com.project.sapbackend.repository.AdministrativeObjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministrativeObjectService {
    private final AdministrativeObjectRepo administrativeObjectRepo;

    public List<AdministrativeObject> findAll() {
        return administrativeObjectRepo.findAll();
    }
}
