package com.project.sapbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "request_types")
public class RequestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    @JsonBackReference
    private ITServiceCatalog service;

    @Column(nullable = false)
    private String typeName;
}
