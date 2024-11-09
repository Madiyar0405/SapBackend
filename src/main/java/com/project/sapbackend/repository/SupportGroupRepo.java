package com.project.sapbackend.repository;


import com.project.sapbackend.entity.Employee;
import com.project.sapbackend.entity.SupportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportGroupRepo extends JpaRepository<SupportGroup, Long> {
//    List<SupportGroup> findSupportGroupByEm(Employee employee);

//    List<SupportGroup> findAllByEmployeesContaining(Employee employee);
    @Query("select s from SupportGroup s inner join s.employees employees where employees.employeeId = ?1")
    List<SupportGroup> findAllByEmployeesEmployeeId(Integer employeeId);

}
