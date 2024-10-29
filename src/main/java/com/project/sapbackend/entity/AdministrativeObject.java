package com.project.sapbackend.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "administrative_objects")
public class AdministrativeObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Long objectId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "administrativeObject", cascade = CascadeType.ALL)
    private Set<ProductionObject> productionObjects;

}
