package com.project.sapbackend.service;


import com.project.sapbackend.entity.RequestExtensionCause;
import com.project.sapbackend.repository.RequestExtensionCausesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestExtensionCausesService {
    private final RequestExtensionCausesRepo requestExtensionCausesRepo;

    public List<RequestExtensionCause> findAll()
    {
        return requestExtensionCausesRepo.findAll();
    }

}
