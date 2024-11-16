package com.project.sapbackend.dto;


import com.project.sapbackend.entity.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncidentRequestDTO {
    private Long requestId;
    private Set<RequestProcessing> requestProcessings;
    private LocalDateTime registrationDatetime;
    private ITServiceCatalog itServiceCatalog;
    private RequestType requestType;
    private String initiatorName;
    private Location incidentLocation;
    private String additionalInfo;
    private SupportGroup supportGroup;
    private Integer redirectCount;
    private String incidentDescription;
    private AdministrativeObject administrativeObject;
    private ProductionObject productionObject;
    private OpticalFiberLine opticalFiberLine;
    private OpticalFiberLineType opticalFiberLineType;
    private Horizon horizon;
    private CableBrand cableBrand;
    private Integer totalFibers;
    private Double cableLength;
    private LayingMethod layingMethod;
    private byte[] incidentPhoto;
    private IncidentStatus incidentStatus;
}