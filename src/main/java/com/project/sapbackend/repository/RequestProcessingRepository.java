package com.project.sapbackend.repository;

import com.project.sapbackend.entity.RequestProcessing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestProcessingRepository extends JpaRepository<RequestProcessing, Long> {
}
