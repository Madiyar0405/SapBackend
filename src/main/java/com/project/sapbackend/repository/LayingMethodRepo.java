package com.project.sapbackend.repository;


import com.project.sapbackend.entity.LayingMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LayingMethodRepo extends JpaRepository<LayingMethod, Long> {
}
