package com.project.sapbackend.admin;


import com.project.sapbackend.auth.AuthenticationService;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.User;
import com.project.sapbackend.repository.UserRepository;
import com.project.sapbackend.service.IncidentRequestService;
import com.project.sapbackend.service.SupportGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;
    private final SupportGroupService supportGroupService;

    private final IncidentRequestService incidentRequestService;

    @GetMapping("/users/") // todo test turn off on prod
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PutMapping("/incident-request/{incidentId}")
    public ResponseEntity<?> addSupportGroupToIncident(
            @PathVariable Long incidentId,
            @RequestParam Long groupId
    ) {

        IncidentRequest incidentRequest = incidentRequestService.findById(incidentId);
        incidentRequest.setSupportGroup(supportGroupService.findById(groupId));
        return ResponseEntity.ok(incidentRequestService.save(incidentRequest));
    }

}
