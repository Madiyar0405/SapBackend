package com.project.sapbackend.repository;

import com.project.sapbackend.entity.CableBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CableBrandRepo extends JpaRepository<CableBrand, Long> {
}
