package com.project.sapbackend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "administrative_objects")
public class AdministrativeObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer objectId;

    @Column(name = "name", nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


    @OneToMany(mappedBy = "administrativeObject", cascade = CascadeType.ALL)
    private List<ProductionObject> productionObjects;
}