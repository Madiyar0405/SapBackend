package com.project.sapbackend.repository;

import com.project.sapbackend.entity.ProductionObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductionObjectRepo extends JpaRepository<ProductionObject, Integer> {
}
