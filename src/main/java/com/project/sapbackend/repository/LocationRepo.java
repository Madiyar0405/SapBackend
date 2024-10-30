package com.project.sapbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.sapbackend.entity.Location;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
}
