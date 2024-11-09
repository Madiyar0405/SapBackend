package com.project.sapbackend.service;


import com.project.sapbackend.entity.Employee;
import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.SupportGroup;
import com.project.sapbackend.repository.EmployeeRepository;
import com.project.sapbackend.repository.IncidentRequestRepo;
import com.project.sapbackend.repository.SupportGroupRepo;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final SupportGroupRepo supportGroupRepo;

    private final IncidentRequestRepo incidentRequestRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<IncidentRequest> getAllIncidentRequestsForEmployee(Integer employeeId) {

//        Employee employee = employeeRepository.findById(employeeId).get();

//       List<SupportGroup> supportGroupsOfEmployee =  supportGroupRepo.findAll().stream()
//               .map(supportGroup -> supportGroup.getEmployees()
//                       .stream().filter(
//                               employee1 -> employee1.getEmployeeId() == employeeId).collect(Collectors.toList())
//               ).collect(Collectors.toList());
//

        List<SupportGroup> supportGroups = supportGroupRepo.findAllByEmployeesEmployeeId(employeeId);

        for (SupportGroup supportGroup : supportGroups) {
            System.out.println(supportGroup);
        }

        List<IncidentRequest> incidentRequests = supportGroups.stream()
                .flatMap(supportGroup -> incidentRequestRepo.findAllBySupportGroup(supportGroup).stream())
                .collect(Collectors.toList());

        return incidentRequests;
    }


}
