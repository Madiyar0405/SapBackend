package com.project.sapbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incidentrequests")
public class IncidentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;

    @Column(name = "registration_datetime")
    private Timestamp registrationDatetime;

    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "request_type_id")
    private Integer requestTypeId;

    @Column(name = "initiator_name")
    private String initiatorName;

    @Column(name = "incident_location_id")
    private Integer incidentLocationId;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "support_group_id")
    private Integer supportGroupId;

    @Column(name = "redirect_count")
    private Integer redirectCount;

    @Column(name = "incident_description")
    private String incidentDescription;

    @Column(name = "admin_object_id")
    private Integer adminObjectId;

    @Column(name = "production_object_id")
    private Integer productionObjectId;

    @Column(name = "fiber_name_id")
    private Integer fiberNameId;

    @Column(name = "line_type_id")
    private Integer lineTypeId;

    @Column(name = "horizon_id")
    private Integer horizonId;

    @Column(name = "fiber_brand_id")
    private Integer fiberBrandId;

    @Column(name = "total_fibers")
    private Integer totalFibers;

    @Column(name = "cable_length")
    private Double cableLength;

    @Column(name = "laying_method_id")
    private Integer layingMethodId;

    @Column(name = "incident_photo")
    private byte[] incidentPhoto;
}



