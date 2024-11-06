package com.project.sapbackend.service;


import com.project.sapbackend.entity.RequestType;
import com.project.sapbackend.entity.SupportGroup;
import com.project.sapbackend.repository.SupportGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportGroupService {
    private SupportGroupRepo supportGroupRepo;

    public List<SupportGroup> findAll() {
        return supportGroupRepo.findAll();
    }
}
