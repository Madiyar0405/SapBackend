package com.project.sapbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cable_brands")
public class CableBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cable_id")
    private Long cableId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cable_type", nullable = false)
    private String cableType;

}
