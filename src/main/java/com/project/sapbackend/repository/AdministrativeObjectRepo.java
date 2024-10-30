package com.project.sapbackend.repository;


import com.project.sapbackend.entity.AdministrativeObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdministrativeObjectRepo extends JpaRepository<AdministrativeObject, Integer> {

}
