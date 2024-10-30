package com.project.sapbackend.repository;

import com.project.sapbackend.entity.ITServiceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITServiceCatalogRepo extends JpaRepository<ITServiceCatalog, Long> {
}
