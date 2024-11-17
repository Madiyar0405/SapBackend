package com.project.sapbackend.repository;

import com.project.sapbackend.entity.RequestExtensionCause;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequestExtensionCausesRepo extends JpaRepository<RequestExtensionCause, Long> {
}
