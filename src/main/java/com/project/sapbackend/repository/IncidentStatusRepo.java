package com.project.sapbackend.repository;


import com.project.sapbackend.entity.IncidentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentStatusRepo extends JpaRepository<IncidentStatus, Long> {
}
