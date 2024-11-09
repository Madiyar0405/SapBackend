package com.project.sapbackend.service;


import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.repository.IncidentRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentRequestService {
    @Autowired
    private IncidentRequestRepo incidentRequestRepository;

    public IncidentRequest save(IncidentRequest incidentRequest){
        return incidentRequestRepository.save(incidentRequest);
    }

    public List<IncidentRequest> findAll() {
        return incidentRequestRepository.findAll();
    }


    public IncidentRequest findById(Long id) {
        return incidentRequestRepository.findById(id).get();
    }


}
