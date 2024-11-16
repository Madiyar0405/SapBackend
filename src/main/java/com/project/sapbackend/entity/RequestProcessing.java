package com.project.sapbackend.entity;

import javax.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "requestprocessing")
public class RequestProcessing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @ManyToOne
    @JoinColumn(name = "incident_request_id", referencedColumnName = "request_id", nullable = false)
    private IncidentRequest incidentRequest;


    @Column(name = "material_costs")
    private Double materialCosts;

    @Column(name = "solution")
    private String solution;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "incident_status_id")
    private IncidentStatus incidentStatus;

    @ManyToOne
    @JoinColumn(name = "request_status_id")
    private RequestStatus requestStatus;


    @Column(name = "closing_datetime")
    private Timestamp closingDatetime;

    @ManyToMany
    @JoinTable(name = "request_accepted_measures",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "measure_id"))
    private List<AcceptedMeasure> acceptedMeasures;

    @ManyToMany
    @JoinTable(name = "request_executors",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> executors;


    @ManyToMany
    @JoinTable(name = "request_extension_causes_junction",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "cause_id"))
    private List<RequestExtensionCause> requestExtensionCauses;

}
