package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "position", nullable = false)
    private String position;

    @ManyToMany(mappedBy = "executors")
    private List<RequestProcessing> requestProcessings;
}
