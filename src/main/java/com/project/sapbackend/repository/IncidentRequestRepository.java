package com.project.sapbackend.repository;


import com.project.sapbackend.entity.IncidentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRequestRepository extends JpaRepository<IncidentRequest, Long>     {
}
