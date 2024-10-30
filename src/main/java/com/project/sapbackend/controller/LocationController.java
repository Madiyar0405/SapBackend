package com.project.sapbackend.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.project.sapbackend.service.LocationService;
import com.project.sapbackend.entity.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/")
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }
}
