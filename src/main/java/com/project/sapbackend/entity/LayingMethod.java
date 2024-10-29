package com.project.sapbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laying_methods")
public class LayingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "method_id")
    private Long methodId;

    @Column(name = "name", nullable = false)
    private String name;

}