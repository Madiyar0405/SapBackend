package com.project.sapbackend.repository;

import com.project.sapbackend.entity.OpticalFiberLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpticalFiberLineRepo extends JpaRepository<OpticalFiberLine, Long> {
}
