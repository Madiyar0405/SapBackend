package com.project.sapbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "region", nullable = false)
    private String region;

}
