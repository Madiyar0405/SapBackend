package com.project.sapbackend.repository;


import com.project.sapbackend.entity.SupportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportGroupRepo extends JpaRepository<SupportGroup, Long> {
}
