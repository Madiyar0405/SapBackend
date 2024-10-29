package com.project.sapbackend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "optical_fiber_lines")
public class OpticalFiberLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "administrative_object_id")
    private AdministrativeObject administrativeObject;

}