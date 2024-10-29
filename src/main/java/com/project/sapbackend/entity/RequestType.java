package com.project.sapbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "request_types")
public class RequestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ITServiceCatalog itServiceCatalog;

    @Column(name = "type_name", nullable = false)
    private String typeName;

}