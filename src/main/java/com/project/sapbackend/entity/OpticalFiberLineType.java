package com.project.sapbackend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "optical_fiber_line_types")
public class OpticalFiberLineType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
