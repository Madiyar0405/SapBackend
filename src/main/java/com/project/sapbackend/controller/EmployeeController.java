package com.project.sapbackend.controller;


import com.project.sapbackend.entity.Employee;
import com.project.sapbackend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


}
