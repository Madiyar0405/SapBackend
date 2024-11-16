package com.project.sapbackend.service;



import com.project.sapbackend.dto.RequestProcessingDTO;
import com.project.sapbackend.entity.RequestProcessing;
import com.project.sapbackend.entity.RequestType;
import com.project.sapbackend.repository.IncidentRequestRepo;
import com.project.sapbackend.repository.RequestProcessingRepository;
import com.project.sapbackend.repository.RequestTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestProcessingService {
    private final RequestProcessingRepository requestProcessingRepository;

    private final IncidentRequestRepo incidentRequestRepo;
    public List<RequestProcessing> findAll() {
        return requestProcessingRepository.findAll();
    }

    public RequestProcessing createRequestProcessing(RequestProcessingDTO requestProcessingDTO)
    {
        requestProcessingDTO.getRequestProcessing().setIncidentRequest(incidentRequestRepo.findById(requestProcessingDTO.getIncidentRequest().getRequestId()).get());
        return requestProcessingRepository.save(requestProcessingDTO.getRequestProcessing());
    }
}
