package com.project.sapbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "incident_request_causes")
public class IncidentRequestCause {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private IncidentRequest incidentRequest;

    @ManyToOne
    @JoinColumn(name = "cause_id")
    private IncidentCause incidentCause;

}