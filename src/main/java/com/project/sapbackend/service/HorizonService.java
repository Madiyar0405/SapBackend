package com.project.sapbackend.service;


import com.project.sapbackend.entity.Horizon;
import com.project.sapbackend.repository.HorizonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorizonService {
    private final HorizonRepo horizonRepo;

    public List<Horizon> findAll() {
        return horizonRepo.findAll();
    }
}
