package com.project.sapbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class IncidentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @OneToMany(mappedBy = "incidentRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<RequestProcessing> requestProcessings;



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

    @Column(name = "incident_description", columnDefinition = "TEXT", nullable = false)
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
    private byte[] incidentPhoto;

//    @OneToMany(mappedBy = "incidentRequest", cascade = CascadeType.ALL)
//    private Set<IncidentRequestCause> incidentRequestCauses;
}