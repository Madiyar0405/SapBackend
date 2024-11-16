package com.project.sapbackend.service;


import com.project.sapbackend.dto.IncidentRequestDTO;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.RequestProcessing;
import com.project.sapbackend.repository.IncidentRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<IncidentRequestDTO> findAllWithStatus() {
        return findAll().stream()
                .map(incidentRequest -> {
                    Optional<RequestProcessing> latestRequestProcessing = incidentRequest.getRequestProcessings()
                            .stream()
                            .max(Comparator.comparing(RequestProcessing::getClosingDatetime));
                    return IncidentRequestDTO.builder()
                            .requestId(incidentRequest.getRequestId())
                            .requestProcessings(incidentRequest.getRequestProcessings())
                            .registrationDatetime(incidentRequest.getRegistrationDatetime())
                            .itServiceCatalog(incidentRequest.getItServiceCatalog())
                            .requestType(incidentRequest.getRequestType())
                            .initiatorName(incidentRequest.getInitiatorName())
                            .incidentLocation(incidentRequest.getIncidentLocation())
                            .additionalInfo(incidentRequest.getAdditionalInfo())
                            .supportGroup(incidentRequest.getSupportGroup())
                            .redirectCount(incidentRequest.getRedirectCount())
                            .incidentDescription(incidentRequest.getIncidentDescription())
                            .administrativeObject(incidentRequest.getAdministrativeObject())
                            .productionObject(incidentRequest.getProductionObject())
                            .opticalFiberLine(incidentRequest.getOpticalFiberLine())
                            .opticalFiberLineType(incidentRequest.getOpticalFiberLineType())
                            .horizon(incidentRequest.getHorizon())
                            .cableBrand(incidentRequest.getCableBrand())
                            .totalFibers(incidentRequest.getTotalFibers())
                            .cableLength(incidentRequest.getCableLength())
                            .layingMethod(incidentRequest.getLayingMethod())
                            .incidentPhoto(incidentRequest.getIncidentPhoto())
                            .incidentStatus(latestRequestProcessing.map(RequestProcessing::getIncidentStatus).orElse(null))
                            .build();
                })
                .collect(Collectors.toList());
    }



}
