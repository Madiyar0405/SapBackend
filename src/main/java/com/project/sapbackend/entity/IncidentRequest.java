package com.project.sapbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import java.util.Date;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "incidentrequests")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "requestId")
public class IncidentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @OneToMany(mappedBy = "incidentRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<RequestProcessing> requestProcessings;

//cascade = CascadeType.ALL,

    @Column(name = "registration_datetime")
    private LocalDateTime registrationDatetime;

    @PrePersist
    protected void onCreate() {
        this.registrationDatetime = LocalDateTime.now(); // Устанавливает текущее локальное время
    }
    @OneToOne
    @JoinColumn(name = "service_id")
    private ITServiceCatalog itServiceCatalog;

    @ManyToOne
    @JoinColumn(name = "request_type_id")
    private RequestType requestType;

    @Column(name = "initiator_name", nullable = false)
    private String initiatorName;

    @ManyToOne
    @JoinColumn(name = "incident_location_id")
    private Location incidentLocation;

    @Column(name = "additional_info")
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "support_group_id")
    private SupportGroup supportGroup;

    @Column(name = "redirect_count")
    private Integer redirectCount;

    @Column(name = "incident_description", nullable = false)
    private String incidentDescription;

    @OneToOne
    @JoinColumn(name = "admin_object_id")
    private AdministrativeObject administrativeObject;

    @OneToOne
    @JoinColumn(name = "production_object_id")
    private ProductionObject productionObject;

    @OneToOne
    @JoinColumn(name = "fiber_name_id")
    private OpticalFiberLine opticalFiberLine;

    @ManyToOne
    @JoinColumn(name = "line_type_id")
    private OpticalFiberLineType opticalFiberLineType;

    @ManyToOne
    @JoinColumn(name = "horizon_id")
    private Horizon horizon;

    @ManyToOne
    @JoinColumn(name = "fiber_brand_id")
    private CableBrand cableBrand;

    @Column(name = "total_fibers")
    private Integer totalFibers;

    @Column(name = "cable_length")
    private Double cableLength;

    @ManyToOne
    @JoinColumn(name = "laying_method_id")
    private LayingMethod layingMethod;

    @Column(name = "incident_photo")
    @JsonIgnore
    private byte[] incidentPhoto;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "incident_request_causes",
            joinColumns = {@JoinColumn(name = "request_id", referencedColumnName = "request_id")},
            inverseJoinColumns = {@JoinColumn(name = "cause_id", referencedColumnName = "cause_id")}
    )
//    @JsonManagedReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "requestId")
    @JsonIgnoreProperties("incidentRequests") // Prevents serialization of the inverse side
    private Set<IncidentCause> incidentCauses;
}