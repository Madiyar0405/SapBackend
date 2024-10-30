package com.project.sapbackend.service;

import com.project.sapbackend.entity.RequestType;
import com.project.sapbackend.repository.RequestTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestTypeService {
    private final RequestTypeRepo requestTypeRepo;

    public List<RequestType> findAll() {
        return requestTypeRepo.findAll();
    }
}
