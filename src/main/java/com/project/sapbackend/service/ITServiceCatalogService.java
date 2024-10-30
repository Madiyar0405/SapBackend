package com.project.sapbackend.service;


import com.project.sapbackend.entity.ITServiceCatalog;
import com.project.sapbackend.entity.RequestType;
import com.project.sapbackend.repository.ITServiceCatalogRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ITServiceCatalogService {
    private final ITServiceCatalogRepo iTServiceCatalogRepo;

    public List<ITServiceCatalog> findAll(){
        return iTServiceCatalogRepo.findAll();
    }

}
