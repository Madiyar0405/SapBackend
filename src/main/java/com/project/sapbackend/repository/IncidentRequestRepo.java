package com.project.sapbackend.repository;


import com.project.sapbackend.entity.IncidentRequest;
import com.project.sapbackend.entity.SupportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRequestRepo extends JpaRepository<IncidentRequest, Long>     {

    List<IncidentRequest> findAllBySupportGroup(SupportGroup supportGroup);
}
