package com.project.sapbackend.controller;


import com.project.sapbackend.entity.enums.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @GetMapping("/")
    public ResponseEntity<?> getRoles() {
        return ResponseEntity.ok(
                List.of(
                        Role.USER,
                        Role.ANALYST,
                        Role.ENGINEER
                )
        );
    }
}
