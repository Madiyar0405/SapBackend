package com.project.sapbackend.repository;


import com.project.sapbackend.entity.AcceptedMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptedMeasureRepo extends JpaRepository<AcceptedMeasure, Long> {
}
