package com.project.sapbackend.repository;

import com.project.sapbackend.entity.Horizon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HorizonRepo extends JpaRepository<Horizon, Integer> {
}
