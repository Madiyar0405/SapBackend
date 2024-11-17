package com.project.sapbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "requestprocessing")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "requestId", scope = RequestProcessing.class)
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

    @PrePersist
    protected void onCreate() {
        this.closingDatetime = LocalDateTime.now();
    }

    @Column(name = "closing_datetime")
    private LocalDateTime closingDatetime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "request_accepted_measures",
            joinColumns = {@JoinColumn(name = "request_id", referencedColumnName = "request_id")},
            inverseJoinColumns = {@JoinColumn(name = "measure_id", referencedColumnName = "measure_id")}
    )
    @JsonIgnoreProperties("requestProcessings")
    private Set<AcceptedMeasure> acceptedMeasures;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "request_executors",
            joinColumns = {@JoinColumn(name = "request_id", referencedColumnName = "request_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")}
    )
    @JsonIgnoreProperties("requestProcessings")
    private Set<Employee> executors;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "request_extension_causes_junction",
            joinColumns = {@JoinColumn(name = "request_id", referencedColumnName = "request_id")},
            inverseJoinColumns = {@JoinColumn(name = "cause_id", referencedColumnName = "cause_id")}
    )
    @JsonIgnoreProperties("requestProcessings")
    private Set<RequestExtensionCause> requestExtensionCauses;

}
