package com.project.sapbackend.controller;


import com.project.sapbackend.dto.AddSupportGroupEmployeeRequestDto;
import com.project.sapbackend.service.SupportGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/support-group")
@RequiredArgsConstructor
public class SupportGroupController {
    private final SupportGroupService supportGroupService;

    @GetMapping("/")
    public ResponseEntity<?> getAllSupportGroups() {
        return ResponseEntity.ok(supportGroupService.findAll());
    }

    @PutMapping("/add-emplpoyee/{groupId}")
    public ResponseEntity<?> addEmployeeToSupportGroup(@RequestBody AddSupportGroupEmployeeRequestDto request) {
        return ResponseEntity.ok(supportGroupService.addEmployeeToSupportGroup(request.getGroupId(), request.getEmployeeId()));
    }


}
