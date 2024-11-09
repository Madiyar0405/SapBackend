package com.project.sapbackend.service;


import com.project.sapbackend.entity.RequestType;
import com.project.sapbackend.entity.SupportGroup;
import com.project.sapbackend.repository.EmployeeRepository;
import com.project.sapbackend.repository.SupportGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupportGroupService {
    private final SupportGroupRepo supportGroupRepo;
    private final EmployeeRepository employeeRepository;

    public List<SupportGroup> findAll() {

        return supportGroupRepo.findAll();
    }

    public SupportGroup addEmployeeToSupportGroup(Long groupId, Integer employeeId)
    {

        Optional<SupportGroup> supportGroup = supportGroupRepo.findById(groupId);
        SupportGroup supportGroup1 = supportGroup.get();
        supportGroup1.getEmployees().add(employeeRepository.findById(employeeId).get());
        return supportGroupRepo.save(supportGroup1);

    }
}
