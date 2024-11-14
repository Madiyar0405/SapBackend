package com.project.sapbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSupportGroupToIncidentRequestDto {
    private Long incidentId;
    private Long groupId;
}
