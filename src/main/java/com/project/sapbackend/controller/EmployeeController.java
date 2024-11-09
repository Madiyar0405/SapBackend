package com.project.sapbackend.controller;


import com.project.sapbackend.entity.Employee;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.service.EmployeeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @GetMapping("/incident-requests/{employeeId}")
    public ResponseEntity<List<IncidentRequest>> getEmployeeById(@PathVariable Integer employeeId) {

        return ResponseEntity.ok(employeeService.getAllIncidentRequestsForEmployee(employeeId));
    }

}
