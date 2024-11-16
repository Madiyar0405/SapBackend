package com.project.sapbackend.dto;


import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.RequestProcessing;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProcessingDTO {
    private RequestProcessing requestProcessing;
    private IncidentRequest incidentRequest;
}
