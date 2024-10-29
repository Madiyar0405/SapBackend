package com.project.sapbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "incident_causes")
public class IncidentCause {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cause_id")
    private Long causeId;

    @Column(name = "name", nullable = false)
    private String name;

}
