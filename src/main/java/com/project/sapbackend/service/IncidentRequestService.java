package com.project.sapbackend.service;


import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.repository.IncidentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class IncidentRequestService {
    @Autowired
    private IncidentRequestRepository incidentRequestRepository;


    public IncidentRequest save(IncidentRequest incidentRequest){
        return incidentRequestRepository.save(incidentRequest);
    }


}
