package com.project.sapbackend.service;


import com.project.sapbackend.entity.Location;
import com.project.sapbackend.repository.LocationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepo locationRepo;

    public List<Location> findAll() {
        return locationRepo.findAll();
    }
}
