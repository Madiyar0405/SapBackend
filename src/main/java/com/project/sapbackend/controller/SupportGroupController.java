package com.project.sapbackend.controller;


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
    public ResponseEntity<?> addEmployeeToSupportGroup(
            @PathVariable Long groupId,
            @RequestParam Integer employeeId
    )
    {
        return ResponseEntity.ok(supportGroupService.addEmployeeToSupportGroup(groupId, employeeId));
    }



}
