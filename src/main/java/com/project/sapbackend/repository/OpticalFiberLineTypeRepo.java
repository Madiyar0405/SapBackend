package com.project.sapbackend.repository;


import com.project.sapbackend.entity.OpticalFiberLineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpticalFiberLineTypeRepo extends JpaRepository<OpticalFiberLineType, Long> {
}
