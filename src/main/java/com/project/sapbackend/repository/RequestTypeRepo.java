package com.project.sapbackend.repository;

import com.project.sapbackend.entity.RequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestTypeRepo extends JpaRepository<RequestType, Long> {
}
