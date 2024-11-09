package com.project.sapbackend.service;


import com.project.sapbackend.entity.Employee;
import com.project.sapbackend.repository.EmployeeRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
