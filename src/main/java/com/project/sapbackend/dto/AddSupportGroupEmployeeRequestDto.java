package com.project.sapbackend.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AddSupportGroupEmployeeRequestDto {
    private Long groupId;
    private Integer employeeId;
}
